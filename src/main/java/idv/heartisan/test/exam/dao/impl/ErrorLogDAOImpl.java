package idv.heartisan.test.exam.dao.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import idv.heartisan.test.exam.dao.dmo.ErrorLogDMO;
import idv.heartisan.test.exam.dao.mapper.ErrorLogDMOMapper;
import idv.heartisan.test.exam.dao.ErrorLogDAO;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author heartisan
 * @since 2023-11-29
 */
@Service
public class ErrorLogDAOImpl extends ServiceImpl<ErrorLogDMOMapper, ErrorLogDMO> implements ErrorLogDAO {

}
