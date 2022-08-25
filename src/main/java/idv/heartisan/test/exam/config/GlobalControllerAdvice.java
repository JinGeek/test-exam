package idv.heartisan.test.exam.config;

import com.alibaba.fastjson.JSONObject;
import idv.heartisan.test.exam.enums.ErrorEnum;
import idv.heartisan.test.exam.exceptions.BizException;
import idv.heartisan.test.exam.pojo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * @author Jin Qi
 * @date 2022/8/4
 */
@ControllerAdvice
@Slf4j
public class GlobalControllerAdvice {

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R handleException(MethodArgumentNotValidException e) {
        return handleParamException(e);
    }

    @ResponseBody
    @ExceptionHandler(BindException.class)
    public R handleException(BindException e) {
        return handleParamException(e);
    }

    @ResponseBody
    @ExceptionHandler(BizException.class)
    public R handleException(BizException e) {
        log.error("handle biz exception with: {}", e.getMessage());
        e.printStackTrace();
        return R.error(e.getErrorEnum());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public R handleException(Exception e) {
        log.error("handle system exception with: {}", e.getMessage());
        e.printStackTrace();
        return R.error(ErrorEnum.SYSTEM_ERROR);
    }

    private R handleParamException(BindException e) {
        ArrayList<String> errMsgList = new ArrayList<>();
        for (ObjectError oe : e.getBindingResult().getAllErrors()) {
            if (oe instanceof FieldError) {
                String errMsg = ((FieldError) oe).getField() + ": " + oe.getDefaultMessage();
                errMsgList.add(errMsg);
            }
        }
        return R.error(ErrorEnum.PARAM_INVALID.code, JSONObject.toJSONString(errMsgList));
    }
}
