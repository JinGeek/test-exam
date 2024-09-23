package idv.heartisan.test.exam.dao.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import idv.heartisan.test.exam.dao.dmo.QuestionDMO;
import idv.heartisan.test.exam.dao.mapper.QuestionDMOMapper;
import idv.heartisan.test.exam.dao.QuestionDAO;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author heartisan
 * @since 2023-11-29
 */
@Service
public class QuestionDAOImpl extends ServiceImpl<QuestionDMOMapper, QuestionDMO> implements QuestionDAO {

}
