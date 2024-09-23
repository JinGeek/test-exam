package idv.heartisan.test.exam.dao.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import idv.heartisan.test.exam.dao.dmo.SchedulerLockDMO;
import idv.heartisan.test.exam.dao.mapper.SchedulerLockDMOMapper;
import idv.heartisan.test.exam.dao.SchedulerLockDAO;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author heartisan
 * @since 2023-11-29
 */
@Service
public class SchedulerLockDAOImpl extends ServiceImpl<SchedulerLockDMOMapper, SchedulerLockDMO> implements SchedulerLockDAO {

}
