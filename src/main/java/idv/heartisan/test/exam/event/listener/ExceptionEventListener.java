package idv.heartisan.test.exam.event.listener;

import idv.heartisan.test.exam.dao.dmo.ErrorLogDMO;
import idv.heartisan.test.exam.dao.mapper.ErrorLogDMOMapper;
import idv.heartisan.test.exam.event.ExceptionEvent;
import idv.heartisan.test.exam.utils.DozerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author Jin Qi
 * @date 2023/2/8
 */

@Component
@Slf4j
public class ExceptionEventListener {

    @Autowired
    private ErrorLogDMOMapper errorLogDMOMapper;

    @EventListener
    public void listenExceptionEvent(ExceptionEvent e) {
        log.info("event listened: {}...", e.getCode());
        try {
            ErrorLogDMO errorLogDMO = DozerUtil.map(e, ErrorLogDMO.class);
            errorLogDMOMapper.insert(errorLogDMO);
        } catch (Exception ex) {
            log.error("save error log with exception: {}", ex.getMessage());
            ex.printStackTrace();
        }
    }
}
