package idv.heartisan.test.exam.event;

import idv.heartisan.test.exam.enums.ErrorEnum;
import idv.heartisan.test.exam.exceptions.BizException;
import lombok.Data;

/**
 * @author Jin Qi
 * @date 2023/2/8
 */

@Data
public class ExceptionEvent {

    private String code;

    private String msg;

    public ExceptionEvent (String code , String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ExceptionEvent(ErrorEnum errorEnum) {
        this.code = errorEnum.code;
        this.msg = errorEnum.errMsg;
    }

    public ExceptionEvent(BizException e) {
        this(e.getErrorEnum());
    }

}
