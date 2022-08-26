package idv.heartisan.test.exam.test.unit.suite;


import idv.heartisan.test.exam.test.unit.suite.ActorTestSuite;
import idv.heartisan.test.exam.test.unit.suite.TeacherTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 测试套件总入口
 *
 * @author Jin Qi
 * @date 2022/8/23
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ActorTestSuite.class, TeacherTestSuite.class})
class AllTestSuites {
}
