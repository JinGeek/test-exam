package idv.heartisan.test.exam.dao.dmo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 定时任务锁
 * </p>
 *
 * @author jinqi
 * @since 2023-01-19
 */
@Getter
@Setter
@TableName("scheduler_lock")
public class SchedulerLockDMO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增 ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 学号
     */
    private String name;

    /**
     * 任务可执行事件
     */
    private Date executionTime;


}
