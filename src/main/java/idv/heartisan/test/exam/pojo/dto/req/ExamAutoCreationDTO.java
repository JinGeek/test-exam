package idv.heartisan.test.exam.pojo.dto.req;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Jin Qi
 * @date 2022/8/15
 */

@Data
public class ExamAutoCreationDTO {

    /**
     * 教师编号
     */
    @NotEmpty
    private String teacherNum;

    /**
     * 试卷名称
     */
    @NotEmpty
    private String name;

    /**
     * 题目数量
     */
    @NotNull
    @Min(10)
    @Max(100)
    private Integer size;

}
