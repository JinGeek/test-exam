package idv.heartisan.test.exam.assembler;

import idv.heartisan.test.exam.dao.dmo.TeacherDMO;
import idv.heartisan.test.exam.entity.Teacher;
import idv.heartisan.test.exam.utils.DozerUtil;

/**
 * @author Jin Qi
 * @date 2022/8/10
 */
public class TeacherAssembler {

    public static TeacherDMO convert(Teacher teacher) {
        return DozerUtil.map(teacher, TeacherDMO.class);
    }

    public static Teacher convert(TeacherDMO teacherDMO) {
        return DozerUtil.map(teacherDMO, Teacher.class);
    }
}
