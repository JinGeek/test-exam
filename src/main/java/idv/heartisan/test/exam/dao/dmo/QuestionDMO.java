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
@Table(value = "question")
public class QuestionDMO extends Model<QuestionDMO> {

    /**
     * 试卷 ID
     */
    private BigInteger examId;

    /**
     * 题目内容
     */
    private String content;

    /**
     * 预期答案
     */
    private String expectedValue;

    /**
     * 创建时间
     */
    private LocalDateTime createdDate;

    /**
     * 修改时间
     */
    private LocalDateTime updatedDate;

    @Id(keyType = KeyType.Auto)
    private BigInteger id;

}
