package idv.heartisan.test.exam.dao.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import idv.heartisan.test.exam.dao.dmo.StudentDMO;
import idv.heartisan.test.exam.dao.mapper.StudentDMOMapper;
import idv.heartisan.test.exam.dao.StudentDAO;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author heartisan
 * @since 2023-11-29
 */
@Service
public class StudentDAOImpl extends ServiceImpl<StudentDMOMapper, StudentDMO> implements StudentDAO {

}
