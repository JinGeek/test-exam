package idv.heartisan.test.exam.pojo.dto.req;

import idv.heartisan.test.exam.enums.ActorTypeEnum;
import idv.heartisan.test.exam.enums.GenderEnum;
import idv.heartisan.test.exam.validator.EnumCheck;
import idv.heartisan.test.exam.validator.RegisterByEmail;
import idv.heartisan.test.exam.validator.RegisterByPhone;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Jin Qi
 * @date 2022/7/21
 */

@Data
@ApiModel("注册信息参数")
public class RegisterDTO2 {

    /**
     * 手机号
     */
    @NotEmpty(groups = RegisterByPhone.class)
    @ApiModelProperty(value = "手机号", example = "13816553849")
    private String phone;

    /**
     * 邮箱
     */
    @NotEmpty(groups = RegisterByEmail.class)
    @ApiModelProperty(value = "邮箱", example = "shadajin@163.com")
    private String email;

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
    @ApiModelProperty(value = "密码", example = "123123")
    private String password;

    /**
     * 密码
     */
    @NotEmpty
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
    @Max(24)
    @ApiModelProperty(value = "年龄", example = "22")
    private Integer age;

    /**
     * 性别
     * @see GenderEnum
     */
    @NotEmpty
    @EnumCheck(GenderEnum.class)
    @ApiModelProperty(value = "性别", example = "MAN")
    private String gender;
}
