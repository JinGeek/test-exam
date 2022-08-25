package idv.heartisan.test.exam.enums;

/**
 * @author Jin Qi
 * @date 2022/8/3
 */
public enum  ErrorEnum {

    PARAM_INVALID("4-00", "入参不合法"),
    PHONE_NUM_INVALID("4-001", "手机号不合法"),
    PASSWORD_NOT_EQUAL("4-002", "密码不一致"),
    PHONE_NUM_DUPLICATION("4-003", "手机号已存在"),
    TEACH_NUM_NOT_QUALIFIED("4-004", "教师编号不合格"),
    EXAM_NAME_DUPLICATION("4-005", "试卷名称重复"),
    EXAM_ID_INVALID("4-006", "试卷 ID 不合法"),
    TEACHER_UNAUTHORIZED("4-007", "该教师编号无权限"),
    STUDENT_NUM_NOT_QUALIFIED("4-008", "学号不合格"),
    EXAMINATION_ONLY_ONCE("4-009", "您只有一次考试机会"),
    EXAMINATION_NOT_EXIST("4-009", "该考试没有考试记录！"),


    SYSTEM_ERROR("5-00", "系统错误"),
    OBJECT_NOT_NULL("5-001", "对象不可为空"),
    ;

    /**
     * 错误代码
     */
    public final String code;

    /**
     * 错误消息
     */
    public final String errMsg;

    ErrorEnum(String code, String errMsg) {
        this.code = code;
        this.errMsg = errMsg;
    }
}
