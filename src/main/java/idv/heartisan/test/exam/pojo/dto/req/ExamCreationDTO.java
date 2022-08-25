package idv.heartisan.test.exam.pojo.dto.req;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author Jin Qi
 * @date 2022/8/11
 */
@Data
public class ExamCreationDTO {

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
}
