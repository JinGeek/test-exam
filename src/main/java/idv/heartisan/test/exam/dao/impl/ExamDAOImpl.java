package idv.heartisan.test.exam.dao.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import idv.heartisan.test.exam.dao.dmo.ExamDMO;
import idv.heartisan.test.exam.dao.mapper.ExamDMOMapper;
import idv.heartisan.test.exam.dao.ExamDAO;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author heartisan
 * @since 2023-11-29
 */
@Service
public class ExamDAOImpl extends ServiceImpl<ExamDMOMapper, ExamDMO> implements ExamDAO {

}
