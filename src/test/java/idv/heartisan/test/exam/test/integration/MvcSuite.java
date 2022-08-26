package idv.heartisan.test.exam.test.integration;

import idv.heartisan.test.exam.test.integration.TestExamApplicationTests;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

/**
 * @author Jin Qi
 * @date 2022/8/26
 */
@RunWith(JUnitPlatform.class)
@SuiteDisplayName("MVC 测试套件")
@SelectClasses({TestExamApplicationTests.class})
public class MvcSuite {
}
