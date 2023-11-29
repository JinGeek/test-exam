package idv.heartisan.test.exam.dao.def;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

/**
 *  表定义层。
 *
 * @author heartisan
 * @since 2023-11-26
 */
public class SchedulerLockTableDef extends TableDef {

    /**
     * 
     */
    public static final SchedulerLockTableDef SCHEDULER_LOCK_D_M_O = new SchedulerLockTableDef();

    /**
     * 自增 ID
     */
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 学号
     */
    public final QueryColumn NAME = new QueryColumn(this, "name");

    /**
     * 任务可执行事件
     */
    public final QueryColumn EXECUTION_TIME = new QueryColumn(this, "execution_time");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, NAME, EXECUTION_TIME};

    public SchedulerLockTableDef() {
        super("", "scheduler_lock");
    }

}
