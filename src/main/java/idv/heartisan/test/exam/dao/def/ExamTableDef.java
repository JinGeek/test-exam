package idv.heartisan.test.exam.dao.def;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

/**
 *  表定义层。
 *
 * @author heartisan
 * @since 2023-11-26
 */
public class ExamTableDef extends TableDef {

    /**
     * 
     */
    public static final ExamTableDef EXAM_D_M_O = new ExamTableDef();

    /**
     * 自增 ID
     */
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 试卷名称
     */
    public final QueryColumn NAME = new QueryColumn(this, "name");

    /**
     * 教师编号
     */
    public final QueryColumn TEACHER_NUM = new QueryColumn(this, "teacher_num");

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
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, NAME, TEACHER_NUM, CREATED_DATE, UPDATED_DATE};

    public ExamTableDef() {
        super("", "exam");
    }

}
