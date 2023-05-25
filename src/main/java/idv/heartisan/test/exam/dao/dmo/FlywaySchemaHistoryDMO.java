package idv.heartisan.test.exam.dao.dmo;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jin Qi
 * @since 2023-05-25
 */
@Getter
@Setter
@TableName("flyway_schema_history")
public class FlywaySchemaHistoryDMO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer installedRank;

    private String version;

    private String description;

    private String type;

    private String script;

    private Integer checksum;

    private String installedBy;

    private Date installedOn;

    private Integer executionTime;

    private Boolean success;


}
