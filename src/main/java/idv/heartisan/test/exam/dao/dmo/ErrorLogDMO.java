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
@Table(value = "error_log")
public class ErrorLogDMO extends Model<ErrorLogDMO> {

    /**
     * 自增 ID
     */
    @Id(keyType = KeyType.Auto)
    private BigInteger id;

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误消息
     */
    private String msg;

    /**
     * 创建时间
     */
    private LocalDateTime createdDate;

    /**
     * 修改时间
     */
    private LocalDateTime updatedDate;

}
