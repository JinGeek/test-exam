package idv.heartisan.test.exam;


import idv.heartisan.test.exam.test.suite.ActorTestSuite;
import idv.heartisan.test.exam.test.suite.TeacherTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Jin Qi
 * @date 2022/8/23
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ActorTestSuite.class, TeacherTestSuite.class})
class AllTestSuites {
}
