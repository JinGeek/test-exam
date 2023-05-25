package idv.heartisan.test.exam.dao.impl;

import idv.heartisan.test.exam.dao.dmo.TeacherDMO;
import idv.heartisan.test.exam.dao.mapper.TeacherDMOMapper;
import idv.heartisan.test.exam.dao.TeacherDAO;
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
public class TeacherDAOImpl extends ServiceImpl<TeacherDMOMapper, TeacherDMO> implements TeacherDAO {

}
