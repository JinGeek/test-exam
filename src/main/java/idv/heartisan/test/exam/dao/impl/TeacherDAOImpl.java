package idv.heartisan.test.exam.dao.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import idv.heartisan.test.exam.dao.dmo.TeacherDMO;
import idv.heartisan.test.exam.dao.mapper.TeacherDMOMapper;
import idv.heartisan.test.exam.dao.TeacherDAO;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author heartisan
 * @since 2023-11-29
 */
@Service
public class TeacherDAOImpl extends ServiceImpl<TeacherDMOMapper, TeacherDMO> implements TeacherDAO {

}
