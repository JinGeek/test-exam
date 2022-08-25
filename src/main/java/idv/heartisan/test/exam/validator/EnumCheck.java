package idv.heartisan.test.exam.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Jin Qi
 * @date 2022/8/3
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumValidator.class)
public @interface EnumCheck {

    String message() default "枚举数据不合法";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    Class value();
}
