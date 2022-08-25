package idv.heartisan.test.exam.assembler;

import idv.heartisan.test.exam.dao.dmo.StudentDMO;
import idv.heartisan.test.exam.entity.Student;
import idv.heartisan.test.exam.utils.DozerUtil;

/**
 * @author Jin Qi
 * @date 2022/8/10
 */
public class StudentAssembler {

    public static StudentDMO convert(Student student) {
        return DozerUtil.map(student, StudentDMO.class);
    }
}
