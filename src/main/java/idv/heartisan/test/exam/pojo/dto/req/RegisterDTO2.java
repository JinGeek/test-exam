package idv.heartisan.test.exam.pojo.dto.req;

import idv.heartisan.test.exam.enums.ActorTypeEnum;
import idv.heartisan.test.exam.enums.GenderEnum;
import idv.heartisan.test.exam.validator.EnumCheck;
import idv.heartisan.test.exam.validator.RegisterByEmail;
import idv.heartisan.test.exam.validator.RegisterByPhone;
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
public class RegisterDTO2 {

    /**
     * 手机号
     */
    @NotEmpty(groups = RegisterByPhone.class)
    private String phone;

    /**
     * 邮箱
     */
    @NotEmpty(groups = RegisterByEmail.class)
    private String email;

    /**
     * 用户类型
     * @see ActorTypeEnum
     */
    @NotEmpty
    @EnumCheck(ActorTypeEnum.class)
    private String actorType;

    /**
     * 密码
     */
    @NotEmpty
    private String password;

    /**
     * 密码
     */
    @NotEmpty
    private String passwordDuplication;

    /**
     * 姓名
     */
    @NotEmpty
    private String name;

    /**
     * 年龄
     */
    @NotNull
    @Min(12)
    @Max(24)
    private Integer age;

    /**
     * 性别
     * @see GenderEnum
     */
    @NotEmpty
    @EnumCheck(GenderEnum.class)
    private String gender;
}
