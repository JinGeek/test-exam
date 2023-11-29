package idv.heartisan.test.exam.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Jin Qi
 * @date 2023/2/3
 */
//@Component
@Slf4j
public class Test1Scheduler extends CommonScheduler {

    public int seq = 1;

//    @Scheduled(fixedDelay = 5 * 1000)
    public void call () {
        super.call();
    }

    @Override
    public String getTaskName() {
        return "test1";
    }

    @Override
    public void execute() {
        log.info("{} task[{}]...", getTaskName(), seq);
    }

    @Override
    public long getPeriod() {
        return 5 * 1000;
    }
}
