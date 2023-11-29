package idv.heartisan.test.exam.dao.dmo;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import com.mybatisflex.core.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 *  实体类。
 *
 * @author heartisan
 * @since 2023-11-26
 */
@Accessors(chain = true)
@Data(staticConstructor = "create")
@EqualsAndHashCode(callSuper = true)
@Table(value = "scheduler_lock")
public class SchedulerLockDMO extends Model<SchedulerLockDMO> {

    /**
     * 自增 ID
     */
    @Id(keyType = KeyType.Auto)
    private BigInteger id;

    /**
     * 学号
     */
    private String name;

    /**
     * 任务可执行事件
     */
    private LocalDateTime executionTime;

}
