package idv.heartisan.test.exam.entity;

import idv.heartisan.test.exam.enums.GenderEnum;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * 教师实体
 *
 * @author Jin Qi
 * @date 2022/7/21
 */

@Data
public class Teacher {

    /**
     * 教师编号
     */
    private String teacherNum;

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
     * 创建时间
     */
    private Date createdDate;

    /**
     * 添加教师实体的准备工作：
     * 1. 分配教师编号
     */
    public void preparation() {
        this.teacherNum = System.currentTimeMillis() + "";
    }


    /**
     * 该教师是否合格
     *
     * @return
     */
    public boolean isQualified() {
        return (System.currentTimeMillis() - createdDate.getTime()) > 1000 * 60 * 60 * 24;
    }
}
