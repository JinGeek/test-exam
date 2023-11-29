package idv.heartisan.test.exam.scheduler;

import idv.heartisan.test.exam.dao.dmo.SchedulerLockDMO;
import idv.heartisan.test.exam.dao.mapper.SchedulerLockDMOMapper;
import idv.heartisan.test.exam.enums.ErrorEnum;
import idv.heartisan.test.exam.exceptions.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author Jin Qi
 * @date 2023/1/19
 */

@Slf4j
public abstract class CommonScheduler {

    @Autowired
    private SchedulerLockDMOMapper schedulerLockDMOMapper;

    public int seq = 0;

    @Transactional
    public void call() {
        log.info("The call time is: {}", new Date());
//        SchedulerLockDMO schedulerLockDMO = schedulerLockDMOMapper.getByName(getTaskName());
//        if (schedulerLockDMO == null) {
//            // 定时任务不存在测报错
//            throw new BizException(ErrorEnum.SCHEDULER_NOT_EXIST);
//        }
//
//        // 当前时间晚于任务可执行时间则执行任务
//        if (new Date().getTime() >= schedulerLockDMO.getExecutionTime().getTime()) {
//            // 具体业务逻辑
//            log.info("do something...");
//            execute();
//
//            schedulerLockDMO.setExecutionTime(new Date(new Date().getTime() + getPeriod()));
//            log.info("set up next execution time: {}", schedulerLockDMO.getExecutionTime());
//            schedulerLockDMOMapper.updateById(schedulerLockDMO);
//        }

    }

    public abstract String getTaskName();

    public abstract void execute();

    public abstract long getPeriod();

}
