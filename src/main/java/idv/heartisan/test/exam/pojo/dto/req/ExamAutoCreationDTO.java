package idv.heartisan.test.exam.pojo.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("创建试题参数")
public class ExamAutoCreationDTO {

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

    /**
     * 试题数量
     */
    @NotNull
    @Min(10)
    @Max(100)
    @ApiModelProperty(value = "试题数量", example = "10")
    private Integer size;

}
