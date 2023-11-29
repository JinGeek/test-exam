package idv.heartisan.test.exam.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

/**
 * 答题记录
 *
 * @author Jin Qi
 * @date 2022/7/22
 */

@Data
public class AnswerRecord {

    /**
     * 答题 ID
     */
    private Long id;

    /**
     * 试题 ID
     */
    private Long questionId;

    /**
     * 考试记录 ID
     */
    private Long examRecordId;

    /**
     * 正确答案
     */
    private String expectedValue;

    /**
     * 作答答案（数据库不做冗余）
     */
    private String answerValue;

    /**
     * 此答案是否正确
     *
     * @return
     */
    public boolean isCorrect() {
        return ObjectUtils.nullSafeEquals(expectedValue, answerValue);
    }

}
