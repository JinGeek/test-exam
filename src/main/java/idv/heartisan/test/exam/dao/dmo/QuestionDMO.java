package idv.heartisan.test.exam.dao.dmo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @author jinqi
 * @since 2022-08-12
 */
@Getter
@Setter
@TableName("question")
public class QuestionDMO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增 ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 试卷 ID
     */
    private Long examId;

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
    private Date createdDate;

    /**
     * 修改时间
     */
    private Date updatedDate;


}
