package idv.heartisan.test.exam.dao.def;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

/**
 *  表定义层。
 *
 * @author heartisan
 * @since 2023-11-26
 */
public class QuestionTableDef extends TableDef {

    /**
     * 
     */
    public static final QuestionTableDef QUESTION_D_M_O = new QuestionTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 试卷 ID
     */
    public final QueryColumn EXAM_ID = new QueryColumn(this, "exam_id");

    /**
     * 题目内容
     */
    public final QueryColumn CONTENT = new QueryColumn(this, "content");

    /**
     * 创建时间
     */
    public final QueryColumn CREATED_DATE = new QueryColumn(this, "created_date");

    /**
     * 修改时间
     */
    public final QueryColumn UPDATED_DATE = new QueryColumn(this, "updated_date");

    /**
     * 预期答案
     */
    public final QueryColumn EXPECTED_VALUE = new QueryColumn(this, "expected_value");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{EXAM_ID, CONTENT, EXPECTED_VALUE, CREATED_DATE, UPDATED_DATE, ID};

    public QuestionTableDef() {
        super("", "question");
    }

}
