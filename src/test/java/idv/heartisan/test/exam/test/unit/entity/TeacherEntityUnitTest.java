package idv.heartisan.test.exam.test.unit.entity;

import idv.heartisan.test.exam.entity.Teacher;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Jin Qi
 * @date 2022/8/25
 */
@DisplayName("老师实体单测 -->")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TeacherEntityUnitTest {

    private Teacher teacher;

    @BeforeAll
    public void setup() {
        System.out.println("teacher instance setting up...");
        teacher = new Teacher();
        teacher.setCreatedDate(new Date());
    }

    @DisplayName("教师初始化")
    @Test
    public void preparationTest() {
        teacher.preparation();
        assertNotNull(teacher.getTeacherNum(), "教师编号为空！");
        assertTrue(System.currentTimeMillis() - Long.parseLong(teacher.getTeacherNum()) < 100, "教师编号规则错误！");
    }

    @DisplayName("教师资格")
    @Test
    public void isQualifiedTest() {
        assertTrue(!teacher.isQualified(), "刚注册的教师不具备资格！");
        teacher.setCreatedDate(new Date(teacher.getCreatedDate().getTime() - 1000 * 60 * 60 * 24));
        assertTrue(teacher.isQualified(), "教师注册 24 小时之后具备资格！");
    }

}
