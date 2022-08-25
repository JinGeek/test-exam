package idv.heartisan.test.exam.service.app;

import idv.heartisan.test.exam.entity.Actor;
import idv.heartisan.test.exam.entity.Student;
import idv.heartisan.test.exam.entity.Teacher;
import idv.heartisan.test.exam.enums.ActorTypeEnum;
import idv.heartisan.test.exam.enums.ErrorEnum;
import idv.heartisan.test.exam.exceptions.BizException;
import idv.heartisan.test.exam.pojo.R;
import idv.heartisan.test.exam.assembler.RegisterAssembler;
import idv.heartisan.test.exam.pojo.dto.req.RegisterDTO;
import idv.heartisan.test.exam.service.entity.ActorService;
import idv.heartisan.test.exam.service.entity.StudentService;
import idv.heartisan.test.exam.service.entity.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Triple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

/**
 * @author Jin Qi
 * @date 2022/8/5
 */
@Service
@Transactional
@Slf4j
public class ActorAppService {

    @Autowired
    private ActorService actorService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    public R register(RegisterDTO registerDTO) {
        // 1. 参数校验
        registerValidation(registerDTO);

        // 2. 生成实体
        Triple<Actor, Student, Teacher> triple = RegisterAssembler.covertAll(registerDTO);

        // 3. 注册新用户
        Actor actor = triple.getLeft();
        Assert.notNull(actor, "actor 不可为 null");
        actorService.newActor(actor);
        if (actor.getActorType() == ActorTypeEnum.STUDENT) {
            studentService.newStudent(triple.getMiddle());
        } else {
            teacherService.newTeacher(triple.getRight());
        }

        return R.ok();
    }

    private void registerValidation(RegisterDTO registerDTO) {
        if (!ObjectUtils.nullSafeEquals(registerDTO.getPassword(), registerDTO.getPasswordDuplication())) {
            throw new BizException(ErrorEnum.PASSWORD_NOT_EQUAL);
        }
    }
}
