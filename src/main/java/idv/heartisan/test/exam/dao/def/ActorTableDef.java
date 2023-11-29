package idv.heartisan.test.exam.dao.def;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

/**
 *  表定义层。
 *
 * @author heartisan
 * @since 2023-11-26
 */
public class ActorTableDef extends TableDef {

    /**
     * 
     */
    public static final ActorTableDef ACTOR_D_M_O = new ActorTableDef();

    /**
     * 自增 ID
     */
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 手机号
     */
    public final QueryColumn PHONE = new QueryColumn(this, "phone");

    /**
     * 用户 ID
     */
    public final QueryColumn ACTOR_ID = new QueryColumn(this, "actor_id");

    /**
     * 密码
     */
    public final QueryColumn PASSWORD = new QueryColumn(this, "password");

    /**
     * 用户类型
     */
    public final QueryColumn ACTOR_TYPE = new QueryColumn(this, "actor_type");

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
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, ACTOR_ID, PHONE, ACTOR_TYPE, PASSWORD, CREATED_DATE, UPDATED_DATE};

    public ActorTableDef() {
        super("", "actor");
    }

}
