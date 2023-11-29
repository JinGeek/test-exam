package idv.heartisan.test.exam.config;

import com.mybatisflex.core.FlexGlobalConfig;
import com.mybatisflex.core.audit.AuditManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jin Qi
 * @date 2023/11/26
 */

@Configuration
public class MyBatisFlexConfiguration {

    private static final Logger logger = LoggerFactory
            .getLogger("mybatis-flex-sql");


    public MyBatisFlexConfiguration() {
        FlexGlobalConfig.getDefaultConfig().setVersionColumn("version");
        //开启审计功能
        AuditManager.setAuditEnable(true);

        //设置 SQL 审计收集器
        AuditManager.setMessageCollector(auditMessage ->
                logger.info("{},{}ms", auditMessage.getFullSql()
                        , auditMessage.getElapsedTime())
        );
    }
}
