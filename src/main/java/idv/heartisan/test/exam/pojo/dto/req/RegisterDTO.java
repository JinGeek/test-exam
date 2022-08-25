package idv.heartisan.test.exam.pojo.dto.req;

import idv.heartisan.test.exam.enums.ActorTypeEnum;
import idv.heartisan.test.exam.enums.GenderEnum;
import idv.heartisan.test.exam.validator.EnumCheck;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * @author Jin Qi
 * @date 2022/7/21
 */

@Data
public class RegisterDTO {

    /**
     * 手机号
     */
    @NotEmpty
    @Pattern(regexp = "^[1][3,4,5,7,8][0-9]{9}$")
    private String phone;

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
    @Size(min = 6, max = 12)
    private String password;

    /**
     * 密码
     */
    @NotEmpty
    @Size(min = 6, max = 12)
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
    @Max(60)
    private Integer age;

    /**
     * 性别
     * @see idv.heartisan.test.exam.enums.GenderEnum
     */
    @NotEmpty
    @EnumCheck(GenderEnum.class)
    private String gender;
}
