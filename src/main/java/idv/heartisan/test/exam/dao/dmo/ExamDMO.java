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
@Table(value = "exam")
public class ExamDMO extends Model<ExamDMO> {

    /**
     * 自增 ID
     */
    @Id(keyType = KeyType.Auto)
    private BigInteger id;

    /**
     * 试卷名称
     */
    private String name;

    /**
     * 教师编号
     */
    private String teacherNum;

    /**
     * 创建时间
     */
    private LocalDateTime createdDate;

    /**
     * 修改时间
     */
    private LocalDateTime updatedDate;

}
