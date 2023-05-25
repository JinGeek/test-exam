package idv.heartisan.test.exam.dao.impl;

import idv.heartisan.test.exam.dao.dmo.ErrorLogDMO;
import idv.heartisan.test.exam.dao.mapper.ErrorLogDMOMapper;
import idv.heartisan.test.exam.dao.ErrorLogDAO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 错误日志表 服务实现类
 * </p>
 *
 * @author Jin Qi
 * @since 2023-05-25
 */
@Service
public class ErrorLogDAOImpl extends ServiceImpl<ErrorLogDMOMapper, ErrorLogDMO> implements ErrorLogDAO {

}
