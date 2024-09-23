package idv.heartisan.test.exam.domain.service;

import idv.heartisan.test.exam.assembler.StudentAssembler;
import idv.heartisan.test.exam.dao.def.StudentTableDef;
import idv.heartisan.test.exam.dao.dmo.StudentDMO;
import idv.heartisan.test.exam.dao.mapper.StudentDMOMapper;
import idv.heartisan.test.exam.domain.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jin Qi
 * @date 2022/8/5
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class StudentService {

    @Autowired
    private StudentDMOMapper studentDMOMapper;

    public void newStudent(Student student) {
        student.preparation();
        StudentDMO studentDMO = StudentAssembler.convert(student);
        studentDMOMapper.insert(studentDMO);
    }

    public boolean isQualified(String stuNum) {
        StudentDMO studentDMO = studentDMOMapper.selectOneByCondition(StudentTableDef.STUDENT_D_M_O.STU_NUM.eq(stuNum));
        if (studentDMO == null) {
            return false;
        }
        return true;
    }
}
