package idv.heartisan.test.exam.dao.impl;

import idv.heartisan.test.exam.dao.dmo.ExamRecordDMO;
import idv.heartisan.test.exam.dao.mapper.ExamRecordDMOMapper;
import idv.heartisan.test.exam.dao.ExamRecordDAO;
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
public class ExamRecordDAOImpl extends ServiceImpl<ExamRecordDMOMapper, ExamRecordDMO> implements ExamRecordDAO {

}
