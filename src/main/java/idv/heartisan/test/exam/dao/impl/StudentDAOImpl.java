package idv.heartisan.test.exam.dao.impl;

import idv.heartisan.test.exam.dao.dmo.StudentDMO;
import idv.heartisan.test.exam.dao.mapper.StudentDMOMapper;
import idv.heartisan.test.exam.dao.StudentDAO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jin Qi
 * @since 2023-05-25
 */
@Service
public class StudentDAOImpl extends ServiceImpl<StudentDMOMapper, StudentDMO> implements StudentDAO {

}
