package idv.heartisan.test.exam.dao.def;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

/**
 *  表定义层。
 *
 * @author heartisan
 * @since 2023-11-26
 */
public class AnswerRecordTableDef extends TableDef {

    /**
     * 
     */
    public static final AnswerRecordTableDef ANSWER_RECORD_D_M_O = new AnswerRecordTableDef();

    /**
     * 自增 ID
     */
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 题目 ID
     */
    public final QueryColumn QUESTION_ID = new QueryColumn(this, "question_id");

    /**
     * 作答答案
     */
    public final QueryColumn ANSWER_VALUE = new QueryColumn(this, "answer_value");

    /**
     * 创建时间
     */
    public final QueryColumn CREATED_DATE = new QueryColumn(this, "created_date");

    /**
     * 修改时间
     */
    public final QueryColumn UPDATED_DATE = new QueryColumn(this, "updated_date");

    /**
     * 考试 ID
     */
    public final QueryColumn EXAM_RECORD_ID = new QueryColumn(this, "exam_record_id");

    /**
     * 正确答案
     */
    public final QueryColumn EXPECTED_VALUE = new QueryColumn(this, "expected_value");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, EXAM_RECORD_ID, QUESTION_ID, EXPECTED_VALUE, ANSWER_VALUE, CREATED_DATE, UPDATED_DATE};

    public AnswerRecordTableDef() {
        super("", "answer_record");
    }

}
