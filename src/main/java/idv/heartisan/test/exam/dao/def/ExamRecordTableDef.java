package idv.heartisan.test.exam.dao.def;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

/**
 *  表定义层。
 *
 * @author heartisan
 * @since 2023-11-26
 */
public class ExamRecordTableDef extends TableDef {

    /**
     * 
     */
    public static final ExamRecordTableDef EXAM_RECORD_D_M_O = new ExamRecordTableDef();

    /**
     * 自增 ID
     */
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 考试成绩
     */
    public final QueryColumn SCORE = new QueryColumn(this, "score");

    /**
     * 试卷 ID
     */
    public final QueryColumn EXAM_ID = new QueryColumn(this, "exam_id");

    /**
     * 学号
     */
    public final QueryColumn STU_NUM = new QueryColumn(this, "stu_num");

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
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, EXAM_ID, STU_NUM, SCORE, CREATED_DATE, UPDATED_DATE};

    public ExamRecordTableDef() {
        super("", "exam_record");
    }

}
