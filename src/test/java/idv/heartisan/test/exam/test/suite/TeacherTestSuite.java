package idv.heartisan.test.exam.test.suite;

import idv.heartisan.test.exam.test.unit.entity.TeacherEntityUnitTest;
import idv.heartisan.test.exam.test.unit.service.TeacherEntityServiceUnitTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

/**
 * @author Jin Qi
 * @date 2022/8/25
 */
@RunWith(JUnitPlatform.class)
@SuiteDisplayName("教师单测套件")
@SelectClasses({TeacherEntityUnitTest.class, TeacherEntityServiceUnitTest.class})
public class TeacherTestSuite {
}
