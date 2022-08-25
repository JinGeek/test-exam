package idv.heartisan.test.exam.enums;

/**
 * @author Jin Qi
 * @date 2022/7/21
 */


public enum GenderEnum {

    MAN(1, "男"), WOMAN(0, "女");

    /**
     * 性别代码
     */
    public final int code;

    /**
     * 性别文字
     */
    public final String text;

    GenderEnum(int code, String text) {
        this.code = code;
        this.text = text;
    }
}
