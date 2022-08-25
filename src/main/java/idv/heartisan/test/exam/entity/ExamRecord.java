package idv.heartisan.test.exam.entity;

import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * 考试记录
 *
 * @author Jin Qi
 * @date 2022/7/22
 */
@Data
public class ExamRecord {

    /**
     * 考试 ID
     */
    private Long id;

    /**
     * 试卷 ID
     */
    private Long examId;

    /**
     * 应试者
     */
    private String stuNum;

    /**
     * 答题记录
     */
    List<AnswerRecord> answerRecords;

    /**
     * 获取得分
     *
     * @return
     */
    public Double getScore() {
        if (CollectionUtils.isEmpty(answerRecords)) {
            return 0.0;
        }

        long correctCount = answerRecords
                .stream()
                .filter(o -> o.isCorrect())
                .count();
        return (new BigDecimal(correctCount)).divide(new BigDecimal(answerRecords.size()), 2, RoundingMode.HALF_DOWN).doubleValue() * 100;
    }

    /**
     * 获取考试等级
     *
     * @return
     */
    public String getGrade() {
        double score = getScore();
        if (score > 98) {
            return "A+";
        }
        if (score > 95) {
            return "A";
        }
        if (score > 90) {
            return "A-";
        }
        if (score > 80) {
            return "B";
        }
        if (score > 70) {
            return "C";
        }
        if (score > 60) {
            return "D";
        }
        return "E";
    }

}
