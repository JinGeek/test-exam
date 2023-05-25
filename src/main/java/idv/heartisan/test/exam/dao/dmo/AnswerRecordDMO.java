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
 * @author Jin Qi
 * @since 2023-05-25
 */
@Getter
@Setter
@TableName("answer_record")
public class AnswerRecordDMO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增 ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 考试 ID
     */
    private Long examRecordId;

    /**
     * 题目 ID
     */
    private Long questionId;

    /**
     * 正确答案
     */
    private String expectedValue;

    /**
     * 作答答案
     */
    private String answerValue;

    /**
     * 创建时间
     */
    private Date createdDate;

    /**
     * 修改时间
     */
    private Date updatedDate;


}
