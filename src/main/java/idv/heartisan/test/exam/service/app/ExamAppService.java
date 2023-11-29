package idv.heartisan.test.exam.service.app;

import idv.heartisan.test.exam.assembler.ExamAssembler;
import idv.heartisan.test.exam.assembler.ExamRecordAssembler;
import idv.heartisan.test.exam.assembler.QuestionAssembler;
import idv.heartisan.test.exam.entity.AnswerRecord;
import idv.heartisan.test.exam.entity.Exam;
import idv.heartisan.test.exam.entity.ExamRecord;
import idv.heartisan.test.exam.entity.Question;
import idv.heartisan.test.exam.enums.ErrorEnum;
import idv.heartisan.test.exam.exceptions.BizException;
import idv.heartisan.test.exam.pojo.R;
import idv.heartisan.test.exam.pojo.dto.req.ExamAutoCreationDTO;
import idv.heartisan.test.exam.pojo.dto.req.ExamCreationDTO;
import idv.heartisan.test.exam.pojo.dto.req.FakeExaminationDTO;
import idv.heartisan.test.exam.pojo.dto.req.QuestionCreationDTO;
import idv.heartisan.test.exam.pojo.dto.resp.ExamScoreDTO;
import idv.heartisan.test.exam.pojo.dto.resp.ExaminationResultDTO;
import idv.heartisan.test.exam.service.entity.*;
import idv.heartisan.test.exam.utils.DozerUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Jin Qi
 * @date 2022/8/10
 */

@Service
@Transactional
@Slf4j
public class ExamAppService {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private ExamService examService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ExamRecordService examRecordService;

    @Autowired
    private AnswerRecordService answerRecordService;

    public R<BigInteger> createExam(ExamCreationDTO examCreationDTO) {
        // 1. 教师编号校验
        if (!teacherService.isQualified(examCreationDTO.getTeacherNum())) {
            throw new BizException(ErrorEnum.TEACH_NUM_NOT_QUALIFIED);
        }

        // 2. 创建试卷
        Exam exam = ExamAssembler.convert(examCreationDTO);
        BigInteger id = examService.newExam(exam);
        return R.ok(id);
    }

    public R<Long> createQuestion(QuestionCreationDTO questionCreationDTO) {
        // 1. 教师编号校验
        if (!teacherService.isQualified(questionCreationDTO.getTeacherNum())) {
            throw new BizException(ErrorEnum.TEACH_NUM_NOT_QUALIFIED);
        }
        Exam exam = examService.getExamById(questionCreationDTO.getExamId());
        if (!ObjectUtils.nullSafeEquals(exam.getTeacherNum(), questionCreationDTO.getTeacherNum())) {
            throw new BizException(ErrorEnum.TEACHER_UNAUTHORIZED);
        }

        // 2. 创建试题
        Question question = QuestionAssembler.convert(questionCreationDTO);
        questionService.newQuestion(question);
        return R.ok(question.getId());
    }

    public  R<BigInteger> autoCreateExam(ExamAutoCreationDTO examAutoCreationDTO) {
        // 1. 创建试卷
        ExamCreationDTO examCreationDTO = DozerUtil.map(examAutoCreationDTO, ExamCreationDTO.class);
        R<BigInteger> examResult = createExam(examCreationDTO);

        // 2. 创建试题
        List<Pair<String, String>> questionList = genQuestions(examAutoCreationDTO.getSize());
        for (int i = 0; i < examAutoCreationDTO.getSize(); i++) {
            Pair<String, String> pair = questionList.get(i);
            Question question  = new Question();
            question.setExamId(examResult.getContent().longValue());
            question.setContent(pair.getLeft());
            question.setExpectedValue(pair.getRight());
            questionService.newQuestion(question);
        }
        return examResult;
    }

    public R<ExaminationResultDTO> fakeExamination(FakeExaminationDTO fakeExaminationDTO) {
        // 1. 验证学号
        if (!studentService.isQualified(fakeExaminationDTO.getStuNum())) {
            throw new BizException(ErrorEnum.STUDENT_NUM_NOT_QUALIFIED);
        }

        // 2. 自动考试
        // 2.1 只能参加一次考试
        if (examRecordService.isExamined(fakeExaminationDTO.getStuNum())) {
            throw new BizException(ErrorEnum.EXAMINATION_ONLY_ONCE);
        }
        // 2.2 保存考试记录
        ExamRecord examRecord = ExamRecordAssembler.convert(fakeExaminationDTO);
        BigInteger examRecordId = examRecordService.newExamRecord(examRecord);
        List<Question> questionList = questionService.queryByExamId(fakeExaminationDTO.getExamId());
        List<AnswerRecord> answerRecordList = genFakeAnswer(questionList, examRecordId.longValue());
        answerRecordService.batchInsert(answerRecordList);
        examRecord.setAnswerRecords(answerRecordList);
        ExaminationResultDTO examinationResultDTO = ExaminationResultDTO.builder()
                .score(examRecord.getScore())
                .answerRecords(answerRecordList)
                .build();
        return R.ok(examinationResultDTO);
    }

    public R<ExamScoreDTO> getScore(String stuNum, Long examId) {
        // 1. 验证学号
        if (!studentService.isQualified(stuNum)) {
            throw new BizException(ErrorEnum.STUDENT_NUM_NOT_QUALIFIED);
        }
        ExamRecord examRecord = examRecordService.getByStuNumAndExamId(stuNum, examId);
        if (examRecord == null) {
            throw new BizException(ErrorEnum.EXAMINATION_NOT_EXIST);
        }
        List<AnswerRecord> answerRecordList = answerRecordService.queryByExamRecordId(examRecord.getId());
        examRecord.setAnswerRecords(answerRecordList);
        ExamScoreDTO examScoreDTO = ExamRecordAssembler.convertToScoreDTO(examRecord);
        return R.ok(examScoreDTO);
    }

    /**
     * 批量生成问题和答案
     *
     * @param size
     * @return
     */
    private List<Pair<String, String>> genQuestions(Integer size) {
        ExpressionParser parser = new SpelExpressionParser();
        Random random = new Random(System.currentTimeMillis());
        List<Pair<String, String>> list = new ArrayList<>();
        for (int i = 0; i <size; i++) {
            int factor1 = random.nextInt(10);
            int factor2 = random.nextInt(10);
            String exp = factor1 + " + " + factor2;
            String value = parser.parseExpression(exp).getValue(Integer.class).toString();
            list.add(ImmutablePair.of(exp, value));
        }
        return list;
    }

    private List<AnswerRecord> genFakeAnswer(List<Question> questionList, Long examRecordId) {
        List<AnswerRecord> answerRecordList = new ArrayList<>();
        Random random = new Random();
        questionList.forEach(question -> {
            AnswerRecord answerRecord = new AnswerRecord();
            answerRecord.setExamRecordId(examRecordId);
            answerRecord.setExpectedValue(question.getExpectedValue());
            answerRecord.setQuestionId(question.getId());
            if (random.nextInt() % 2 == 0) {
                answerRecord.setAnswerValue(question.getExpectedValue());
            } else {
                answerRecord.setAnswerValue(random.nextInt() + "");
            }
            answerRecordList.add(answerRecord);
        });
        return answerRecordList;
    }
}
