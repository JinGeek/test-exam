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
@Table(value = "actor")
public class ActorDMO extends Model<ActorDMO> {

    /**
     * 自增 ID
     */
    @Id(keyType = KeyType.Auto)
    private BigInteger id;

    /**
     * 用户 ID
     */
    private String actorId;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 用户类型
     */
    private String actorType;

    /**
     * 密码
     */
    private String password;

    /**
     * 创建时间
     */
    private LocalDateTime createdDate;

    /**
     * 修改时间
     */
    private LocalDateTime updatedDate;

}
