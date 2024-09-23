package idv.heartisan.test.exam.domain.service;

import com.alibaba.fastjson.JSONObject;
import idv.heartisan.test.exam.assembler.TeacherAssembler;
import idv.heartisan.test.exam.dao.def.TeacherTableDef;
import idv.heartisan.test.exam.dao.dmo.TeacherDMO;
import idv.heartisan.test.exam.dao.mapper.TeacherDMOMapper;
import idv.heartisan.test.exam.domain.entity.Teacher;
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
public class TeacherService {

    @Autowired
    private TeacherDMOMapper teacherDMOMapper;

    /**
     * 创建教师
     *
     * @param teacher
     */
    public void newTeacher(Teacher teacher) {
        teacher.preparation();
        TeacherDMO teacherDMO = TeacherAssembler.convert(teacher);
        teacherDMOMapper.insert(teacherDMO);
    }

    /**
     * 检查教师编号是否合格：
     * 1. 存在
     * 2. 教师注册超过 24 小时
     *
     * @param teachNum
     * @return
     */
    public boolean isQualified(String teachNum) {
        TeacherDMO teacherDMO = teacherDMOMapper.selectOneByCondition(TeacherTableDef.TEACHER_D_M_O.TEACHER_NUM.eq(teachNum));
        System.out.println(JSONObject.toJSONString(teacherDMO));
        if (teacherDMO == null) {
            return false;
        }

        Teacher teacher = TeacherAssembler.convert(teacherDMO);
        return teacher.isQualified();
    }
}
