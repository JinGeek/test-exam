package idv.heartisan.test.exam.dao.def;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

/**
 *  表定义层。
 *
 * @author heartisan
 * @since 2023-11-26
 */
public class ErrorLogTableDef extends TableDef {

    /**
     * 
     */
    public static final ErrorLogTableDef ERROR_LOG_D_M_O = new ErrorLogTableDef();

    /**
     * 自增 ID
     */
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 错误消息
     */
    public final QueryColumn MSG = new QueryColumn(this, "msg");

    /**
     * 错误码
     */
    public final QueryColumn CODE = new QueryColumn(this, "code");

    /**
     * 创建时间
     */
    public final QueryColumn CREATED_DATE = new QueryColumn(this, "created_date");

    /**
     * 修改时间
     */
    public final QueryColumn UPDATED_DATE = new QueryColumn(this, "updated_date");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, CODE, MSG, CREATED_DATE, UPDATED_DATE};

    public ErrorLogTableDef() {
        super("", "error_log");
    }

}
