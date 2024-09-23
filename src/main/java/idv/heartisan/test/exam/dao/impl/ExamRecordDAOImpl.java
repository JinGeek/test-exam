package idv.heartisan.test.exam.dao.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import idv.heartisan.test.exam.dao.dmo.ExamRecordDMO;
import idv.heartisan.test.exam.dao.mapper.ExamRecordDMOMapper;
import idv.heartisan.test.exam.dao.ExamRecordDAO;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author heartisan
 * @since 2023-11-29
 */
@Service
public class ExamRecordDAOImpl extends ServiceImpl<ExamRecordDMOMapper, ExamRecordDMO> implements ExamRecordDAO {

}
