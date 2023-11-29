package idv.heartisan.test.exam.pojo.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author Jin Qi
 * @date 2022/8/11
 */
@Data
@ApiModel("创建试卷参数")
public class ExamCreationDTO {

    /**
     * 教师编号
     */
    @NotEmpty
    @ApiModelProperty(value = "教师编号", example = "1660120578617")
    private String teacherNum;

    /**
     * 试卷名称
     */
    @NotEmpty
    @ApiModelProperty(value = "试卷名称", example = "超级考卷 001")
    private String name;
}
