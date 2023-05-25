package idv.heartisan.test.exam.dao.impl;

import idv.heartisan.test.exam.dao.dmo.QuestionDMO;
import idv.heartisan.test.exam.dao.mapper.QuestionDMOMapper;
import idv.heartisan.test.exam.dao.QuestionDAO;
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
public class QuestionDAOImpl extends ServiceImpl<QuestionDMOMapper, QuestionDMO> implements QuestionDAO {

}
