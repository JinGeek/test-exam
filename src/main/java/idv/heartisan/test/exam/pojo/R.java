package idv.heartisan.test.exam.pojo;

import idv.heartisan.test.exam.enums.ErrorEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 接口通用返回对象
 *
 * @author Jin Qi
 * @date 2022/8/3
 */

@Data
@ApiModel("接口返回对象")
public class R<T> {

    /**
     * 成功返回的代码值
     */
    public static final String SUCCESS_CODE = "2-00";

    /**
     * 返回代码，默认赋值成功代码值
     */
    @ApiModelProperty(value = "返回代码", example = "2-00")
    private String code = SUCCESS_CODE;


    /**
     * 错误消息
     */
    @ApiModelProperty(value = "错误消息", example = "")
    private String errMsg;

    /**
     * 具体返回内容
     */
    @ApiModelProperty(value = "具体返回内容", example = "")
    private T content;

    /**
     * 返回成功
     *
     * @return
     */
    public static R ok() {
        return new R();
    }

    /**
     * 返回具体结果内容
     *
     * @param content
     * @param <T>
     * @return
     */
    public static <T> R<T> ok(T content) {
        R r = new R();
        r.content = content;
        return r;
    }

    /**
     * 返回错误信息
     *
     * @param errorEnum
     * @return
     */
    public static R error(ErrorEnum errorEnum) {
        R r = new R();
        r.setCode( errorEnum.code);
        r.setErrMsg(errorEnum.errMsg);
        return  r;
    }

    /**
     * 返回错误信息
     *
     * @param code
     * @param errMsg
     * @return
     */
    public static R error(String code, String errMsg) {
        R r = new R();
        r.code = code;
        r.errMsg = errMsg;
        return  r;
    }

    /**
     * 此对象是否代表正确结果
     *
     * @return
     */
    public boolean isSuccess() {
        return SUCCESS_CODE.equals(this.code);
    }
}
