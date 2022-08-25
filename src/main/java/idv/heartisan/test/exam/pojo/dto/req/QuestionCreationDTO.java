package idv.heartisan.test.exam.pojo.dto.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Jin Qi
 * @date 2022/8/11
 */
@Data
public class QuestionCreationDTO {

    /**
     * 教师编号
     */
    @NotEmpty
    private String teacherNum;

    /**
     * 试卷 ID
     */
    @NotNull
    private Long examId;

    /**
     * 题目内容
     */
    @NotEmpty
    private String content;

    /**
     * 预期答案
     */
    @NotEmpty
    private String expectedValue;
}
