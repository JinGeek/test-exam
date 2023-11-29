package idv.heartisan.test.exam.pojo.dto.req;

import idv.heartisan.test.exam.enums.ActorTypeEnum;
import idv.heartisan.test.exam.enums.GenderEnum;
import idv.heartisan.test.exam.validator.EnumCheck;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * @author Jin Qi
 * @date 2022/7/21
 */

@Data
@ApiModel("注册信息参数")
public class RegisterDTO {

    /**
     * 手机号
     */
    @NotEmpty
    @Pattern(regexp = "^[1][3,4,5,7,8][0-9]{9}$")
    @ApiModelProperty(value = "手机号", example = "13816553849")
    private String phone;

    /**
     * 用户类型
     * @see ActorTypeEnum
     */
    @NotEmpty
    @EnumCheck(ActorTypeEnum.class)
    @ApiModelProperty(value = "用户类型", example = "STUDENT")
    private String actorType;

    /**
     * 密码
     */
    @NotEmpty
    @Size(min = 6, max = 12)
    @ApiModelProperty(value = "密码", example = "123123")
    private String password;

    /**
     * 密码
     */
    @NotEmpty
    @Size(min = 6, max = 12)
    @ApiModelProperty(value = "密码", example = "123123")
    private String passwordDuplication;

    /**
     * 姓名
     */
    @NotEmpty
    @ApiModelProperty(value = "姓名", example = "Tom")
    private String name;

    /**
     * 年龄
     */
    @NotNull
    @Min(12)
    @Max(60)
    @ApiModelProperty(value = "年龄", example = "22")
    private Integer age;

    /**
     * 性别
     * @see idv.heartisan.test.exam.enums.GenderEnum
     */
    @NotEmpty
    @EnumCheck(GenderEnum.class)
    @ApiModelProperty(value = "性别", example = "MAN")
    private String gender;
}
