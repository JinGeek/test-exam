package idv.heartisan.test.exam.dao.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import idv.heartisan.test.exam.dao.dmo.AnswerRecordDMO;
import idv.heartisan.test.exam.dao.mapper.AnswerRecordDMOMapper;
import idv.heartisan.test.exam.dao.AnswerRecordDAO;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author heartisan
 * @since 2023-11-29
 */
@Service
public class AnswerRecordDAOImpl extends ServiceImpl<AnswerRecordDMOMapper, AnswerRecordDMO> implements AnswerRecordDAO {

}
