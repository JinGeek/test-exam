package idv.heartisan.test.exam.dao.impl;

import idv.heartisan.test.exam.dao.dmo.ExamDMO;
import idv.heartisan.test.exam.dao.mapper.ExamDMOMapper;
import idv.heartisan.test.exam.dao.ExamDAO;
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
public class ExamDAOImpl extends ServiceImpl<ExamDMOMapper, ExamDMO> implements ExamDAO {

}
