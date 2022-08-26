package idv.heartisan.test.exam.test.unit.suite;

import idv.heartisan.test.exam.test.unit.service.ActorAppServiceUnitTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

/**
 * @author Jin Qi
 * @date 2022/8/25
 */

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("用户单测套件")
@SelectClasses({ActorAppServiceUnitTest.class})
public class ActorTestSuite {
}
