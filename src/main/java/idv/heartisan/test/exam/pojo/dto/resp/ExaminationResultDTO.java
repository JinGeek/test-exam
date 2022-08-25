package idv.heartisan.test.exam.pojo.dto.resp;

import idv.heartisan.test.exam.entity.AnswerRecord;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author Jin Qi
 * @date 2022/8/16
 */

@Data
@Builder
public class ExaminationResultDTO {

    private Double score;

    /**
     * 答题记录
     */
    List<AnswerRecord> answerRecords;
}
