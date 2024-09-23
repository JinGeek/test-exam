package idv.heartisan.test.exam.domain.service;

import idv.heartisan.test.exam.assembler.QuestionAssembler;
import idv.heartisan.test.exam.dao.def.QuestionTableDef;
import idv.heartisan.test.exam.dao.dmo.QuestionDMO;
import idv.heartisan.test.exam.dao.mapper.QuestionDMOMapper;
import idv.heartisan.test.exam.domain.entity.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jin Qi
 * @date 2022/8/12
 */

@Service
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS)
public class QuestionService {

    @Autowired
    private QuestionDMOMapper questionDMOMapper;

    /**
     * 新建试题
     *
     * @param question
     */
    public void newQuestion(Question question) {
        QuestionDMO questionDMO = QuestionAssembler.convert(question);
        questionDMOMapper.insert(questionDMO);
    }

    /**
     * 根据试卷 ID 获取所有试题
     *
     * @param examId
     * @return
     */
    public List<Question> queryByExamId(Long examId) {
        List<QuestionDMO> questionDMOList = questionDMOMapper.selectListByCondition(QuestionTableDef.QUESTION_D_M_O.EXAM_ID.eq(examId));

        List<Question> questionList = new ArrayList<>();
        questionDMOList.forEach(o -> questionList.add(QuestionAssembler.convert(o)));
        return questionList;
    }
}
