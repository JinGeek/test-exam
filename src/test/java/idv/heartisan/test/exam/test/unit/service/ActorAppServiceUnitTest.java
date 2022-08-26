package idv.heartisan.test.exam.test.unit.service;

import idv.heartisan.test.exam.enums.ActorTypeEnum;
import idv.heartisan.test.exam.enums.GenderEnum;
import idv.heartisan.test.exam.exceptions.BizException;
import idv.heartisan.test.exam.pojo.dto.req.RegisterDTO;
import idv.heartisan.test.exam.service.app.ActorAppService;
import idv.heartisan.test.exam.service.entity.ActorService;
import idv.heartisan.test.exam.service.entity.StudentService;
import idv.heartisan.test.exam.service.entity.TeacherService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

/**
 * @author Jin Qi
 * @date 2022/8/25
 */

@DisplayName("用户应用服务单测 -->")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class ActorAppServiceUnitTest {

    @InjectMocks
    private ActorAppService actorAppService;

    @Mock
    private ActorService actorService;

    @Mock
    private StudentService studentService;

    @Mock
    private TeacherService teacherService;

    @DisplayName("注册分支")
    @Test
    public void registerTest() {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setPhone("1381655545");
        registerDTO.setActorType(ActorTypeEnum.STUDENT.name());
        registerDTO.setPassword("123123");
        registerDTO.setPasswordDuplication("123123");
        registerDTO.setName("Lucy");
        registerDTO.setAge(27);
        registerDTO.setGender(GenderEnum.MAN.name());
        actorAppService.register(registerDTO);
        verify(studentService).newStudent(any());

        registerDTO.setActorType(ActorTypeEnum.TEACHER.name());
        actorAppService.register(registerDTO);
        verify(teacherService).newTeacher(any());
    }

    @DisplayName("密码一致")
    @Test
    public void passwordEquality() {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setPhone("1381655545");
        registerDTO.setActorType(ActorTypeEnum.STUDENT.name());
        registerDTO.setPassword("123123");
        registerDTO.setPasswordDuplication("1231237");

        assertThrowsExactly(BizException.class, () -> actorAppService.register(registerDTO));
        assertThrows(Exception.class, () -> actorAppService.register(registerDTO));
    }
}
