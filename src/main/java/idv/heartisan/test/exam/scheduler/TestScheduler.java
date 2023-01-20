package idv.heartisan.test.exam.scheduler;

import idv.heartisan.test.exam.dao.dmo.SchedulerLockDMO;
import idv.heartisan.test.exam.dao.mapper.SchedulerLockDMOMapper;
import idv.heartisan.test.exam.enums.ErrorEnum;
import idv.heartisan.test.exam.exceptions.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author Jin Qi
 * @date 2023/1/19
 */

@Component
@Slf4j
public class TestScheduler {

    @Autowired
    private SchedulerLockDMOMapper schedulerLockDMOMapper;

    @Scheduled(fixedDelay = 5 * 1000)
    @Transactional
    public void call() {
        log.info("The call time is: {}", new Date());
        SchedulerLockDMO schedulerLockDMO = schedulerLockDMOMapper.getByName("test");
        if (schedulerLockDMO == null) {
            throw new BizException(ErrorEnum.SCHEDULER_NOT_EXIST);
        }
        if (new Date().getTime() >= schedulerLockDMO.getExecutionTime().getTime()) {
            log.info("do something...");

            schedulerLockDMO.setExecutionTime(new Date(new Date().getTime() + 5 * 1000));
            log.info("set up next execution time: {}", schedulerLockDMO.getExecutionTime());
            schedulerLockDMOMapper.updateById(schedulerLockDMO);
        }

    }
}
