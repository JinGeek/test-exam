package idv.heartisan.test.exam.exceptions;

import idv.heartisan.test.exam.enums.ErrorEnum;
import lombok.Data;

/**
 * 业务自定义异常
 *
 * @author Jin Qi
 * @date 2022/8/5
 */
@Data
public class BizException extends RuntimeException {

    /**
     * 错误枚举
     */
    private ErrorEnum errorEnum;

    public BizException(String msg) {
        super(msg);
    }

    public BizException(ErrorEnum errorEnum) {
        super(errorEnum.code + ": " + errorEnum.errMsg);
        this.errorEnum = errorEnum;
    }
}
