package idv.heartisan.test.exam.assembler;

import idv.heartisan.test.exam.entity.Actor;
import idv.heartisan.test.exam.entity.Student;
import idv.heartisan.test.exam.entity.Teacher;
import idv.heartisan.test.exam.enums.ActorTypeEnum;
import idv.heartisan.test.exam.enums.GenderEnum;
import idv.heartisan.test.exam.pojo.dto.req.RegisterDTO;
import idv.heartisan.test.exam.utils.DozerUtil;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;

/**
 * @author Jin Qi
 * @date 2022/8/5
 */
public class RegisterAssembler {

    public static Triple<Actor, Student, Teacher> covertAll(RegisterDTO registerDTO) {
        Actor actor = DozerUtil.map(registerDTO, Actor.class);
        actor.setActorType(ActorTypeEnum.valueOf(registerDTO.getActorType()));
        Student student = null;
        Teacher teacher = null;
        GenderEnum genderEnum = GenderEnum.valueOf(registerDTO.getGender());
        if (actor.getActorType() == ActorTypeEnum.STUDENT) {
            student = DozerUtil.map(registerDTO, Student.class);
            student.setGender(genderEnum);
        } else {
            teacher = DozerUtil.map(registerDTO, Teacher.class);
            teacher.setGender(genderEnum);
        }
        return new ImmutableTriple<>(actor, student, teacher);
    }
}
