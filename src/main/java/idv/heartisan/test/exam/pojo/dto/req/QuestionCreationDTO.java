package idv.heartisan.test.exam.pojo.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Jin Qi
 * @date 2022/8/11
 */
@Data
@ApiModel("创建试题参数")
public class QuestionCreationDTO {

    /**
     * 教师编号
     */
    @NotEmpty
    @ApiModelProperty(value = "教师编号", example = "1660120578617")
    private String teacherNum;

    /**
     * 试卷 ID
     */
    @NotNull
    @ApiModelProperty(value = "试卷 ID", example = "1")
    private Long examId;

    /**
     * 试题内容
     */
    @NotEmpty
    @ApiModelProperty(value = "试题内容", example = "")
    private String content;

    /**
     * 预期答案
     */
    @NotEmpty
    @ApiModelProperty(value = "预期答案", example = "")
    private String expectedValue;
}
