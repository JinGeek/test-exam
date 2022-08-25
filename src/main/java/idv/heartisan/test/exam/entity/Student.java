package idv.heartisan.test.exam.entity;

import idv.heartisan.test.exam.enums.GenderEnum;
import lombok.Data;

/**
 * 学生实体
 *
 * @author Jin Qi
 * @date 2022/7/21
 */

@Data
public class Student {

    /**
     * 学号
     */
    private String stuNum;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private GenderEnum gender;

    /**
     * 添加学生实体时的准备动作：
     * 1. 分配学号
     */
    public void preparation() {
        this.stuNum = System.currentTimeMillis() + "";
    }

}
