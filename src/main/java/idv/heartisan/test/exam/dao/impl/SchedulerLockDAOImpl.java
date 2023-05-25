package idv.heartisan.test.exam.dao.impl;

import idv.heartisan.test.exam.dao.dmo.SchedulerLockDMO;
import idv.heartisan.test.exam.dao.mapper.SchedulerLockDMOMapper;
import idv.heartisan.test.exam.dao.SchedulerLockDAO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务锁 服务实现类
 * </p>
 *
 * @author Jin Qi
 * @since 2023-05-25
 */
@Service
public class SchedulerLockDAOImpl extends ServiceImpl<SchedulerLockDMOMapper, SchedulerLockDMO> implements SchedulerLockDAO {

}
