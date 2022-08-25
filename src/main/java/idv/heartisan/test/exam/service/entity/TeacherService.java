package idv.heartisan.test.exam.service.entity;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import idv.heartisan.test.exam.assembler.TeacherAssembler;
import idv.heartisan.test.exam.dao.dmo.TeacherDMO;
import idv.heartisan.test.exam.dao.mapper.TeacherDMOMapper;
import idv.heartisan.test.exam.entity.Teacher;
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
        LambdaQueryWrapper<TeacherDMO> condition = new QueryWrapper<TeacherDMO>()
                .lambda()
                .eq(TeacherDMO::getTeacherNum, teachNum);
        TeacherDMO teacherDMO = teacherDMOMapper.selectOne(condition);
        System.out.println(JSONObject.toJSONString(teacherDMO));
        if (teacherDMO == null) {
            return false;
        }

        Teacher teacher = TeacherAssembler.convert(teacherDMO);
        return teacher.isQualified();
    }
}
