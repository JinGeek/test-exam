package idv.heartisan.test.exam.dao.def;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

/**
 *  表定义层。
 *
 * @author heartisan
 * @since 2023-11-26
 */
public class TeacherTableDef extends TableDef {

    /**
     * 
     */
    public static final TeacherTableDef TEACHER_D_M_O = new TeacherTableDef();

    /**
     * 自增 ID
     */
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 年龄
     */
    public final QueryColumn AGE = new QueryColumn(this, "age");

    /**
     * 姓名
     */
    public final QueryColumn NAME = new QueryColumn(this, "name");

    /**
     * 性别
     */
    public final QueryColumn GENDER = new QueryColumn(this, "gender");

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
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, TEACHER_NUM, NAME, AGE, GENDER, CREATED_DATE, UPDATED_DATE};

    public TeacherTableDef() {
        super("", "teacher");
    }

}
