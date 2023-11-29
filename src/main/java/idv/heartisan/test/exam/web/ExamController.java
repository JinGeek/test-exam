package idv.heartisan.test.exam.web;

import idv.heartisan.test.exam.pojo.R;
import idv.heartisan.test.exam.pojo.dto.req.ExamAutoCreationDTO;
import idv.heartisan.test.exam.pojo.dto.req.ExamCreationDTO;
import idv.heartisan.test.exam.pojo.dto.req.FakeExaminationDTO;
import idv.heartisan.test.exam.pojo.dto.req.QuestionCreationDTO;
import idv.heartisan.test.exam.pojo.dto.resp.ExamScoreDTO;
import idv.heartisan.test.exam.pojo.dto.resp.ExaminationResultDTO;
import idv.heartisan.test.exam.service.app.ExamAppService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;

/**
 * 试题、考试相关操作
 *
 * @author Jin Qi
 * @date 2022/8/10
 */

@RestController
@RequestMapping("/exam")
@Api(tags = "试卷及试题相关操作")
@AllArgsConstructor
@Slf4j
public class ExamController {

    private ExamAppService examAppService;

    @ApiOperation("创建试卷")
    @PostMapping(name = "创建试卷", path = "createExam")
    public R<BigInteger> createExam(@Valid @RequestBody ExamCreationDTO examCreationDTO) {
        return examAppService.createExam(examCreationDTO);
    }

    @ApiOperation("创建试题")
    @PostMapping(name = "创建试题", path = "createQuestion")
    public R<Long> createQuestion(@Valid @RequestBody QuestionCreationDTO questionCreationDTO) {
        return examAppService.createQuestion(questionCreationDTO);
    }

    @ApiOperation("自动创建试卷")
    @PostMapping(name = "自动创建试卷", path = "autoCreateExam")
    public  R<BigInteger> autoCreateExam(@Valid @RequestBody ExamAutoCreationDTO examAutoCreationDTO) {
        return examAppService.autoCreateExam(examAutoCreationDTO);
    }

    @ApiOperation("伪考试")
    @PostMapping(name = "伪考试", path = "fakeExamination")
    public R<ExaminationResultDTO> fakeExamination(@Valid @RequestBody FakeExaminationDTO fakeExaminationDTO) {
        return examAppService.fakeExamination(fakeExaminationDTO);
    }

    @ApiOperation("成绩查询")
    @GetMapping(name = "成绩查询", path = "getScore/{stuNum}/{examId}")
    public R<ExamScoreDTO> getScore(@PathVariable String stuNum, @PathVariable Long examId) {
        return examAppService.getScore(stuNum, examId);
    }
}
