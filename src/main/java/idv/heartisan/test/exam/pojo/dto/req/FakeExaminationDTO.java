package idv.heartisan.test.exam.pojo.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Jin Qi
 * @date 2022/8/16
 */

@Data
@ApiModel("伪考试参数")
public class FakeExaminationDTO {

    /**
     * 学号
     */
    @NotEmpty
    @ApiModelProperty(value = "学号", example = "1660119984183")
    private String stuNum;

    /**
     * 试卷 ID
     */
    @NotNull
    @ApiModelProperty(value = "试卷 ID", example = "1")
    private Long examId;
}
