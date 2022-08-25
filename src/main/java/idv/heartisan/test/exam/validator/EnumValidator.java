package idv.heartisan.test.exam.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Jin Qi
 * @date 2022/8/3
 */
public class EnumValidator implements ConstraintValidator<EnumCheck, String> {

    private Class clz;

    @Override
    public void initialize(EnumCheck constraintAnnotation) {
        this.clz = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (clz == null) {
            return true;
        }

        if (clz.isEnum()) {
            for (Object en : clz.getEnumConstants()) {
                for (Method method : clz.getMethods()) {
                    if (method.getName().equals("name")) {
                        try {
                            String name = method.invoke(en).toString();
                            if (name.equals(value)) {
                                return true;
                            }
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            return true;
        }

        return false;
    }
}
