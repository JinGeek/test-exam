package idv.heartisan.test.exam.test.unit.service;

import idv.heartisan.test.exam.dao.dmo.TeacherDMO;
import idv.heartisan.test.exam.dao.mapper.TeacherDMOMapper;
import idv.heartisan.test.exam.service.entity.TeacherService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * @author Jin Qi
 * @date 2022/8/25
 */
@DisplayName("老师实体服务单测 -->")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class TeacherEntityServiceUnitTest {

    @InjectMocks
    private TeacherService teacherService;

    @Mock
    private TeacherDMOMapper teacherDMOMapper;

    @DisplayName("检查教师编号是否合格")
    @Test
    public void isQualifiedTest() {
        TeacherDMO teacherDMO = TeacherDMO.create();
        teacherDMO.setCreatedDate(LocalDateTime.now().minusDays(1));
        when(teacherDMOMapper.selectOne(any())).thenReturn(teacherDMO);
        assertTrue(teacherService.isQualified("11"));
        when(teacherDMOMapper.selectOne(any())).thenReturn(null);
        assertTrue(!teacherService.isQualified("11"));
    }

}
