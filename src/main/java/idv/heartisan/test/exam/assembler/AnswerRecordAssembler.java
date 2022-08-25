package idv.heartisan.test.exam.assembler;

import idv.heartisan.test.exam.dao.dmo.AnswerRecordDMO;
import idv.heartisan.test.exam.entity.AnswerRecord;
import idv.heartisan.test.exam.utils.DozerUtil;

/**
 * @author Jin Qi
 * @date 2022/8/17
 */
public class AnswerRecordAssembler {

    public static AnswerRecordDMO convert(AnswerRecord answerRecord) {
        return DozerUtil.map(answerRecord, AnswerRecordDMO.class);
    }

    public static AnswerRecord convert(AnswerRecordDMO answerRecordDMO) {
        return DozerUtil.map(answerRecordDMO, AnswerRecord.class);
    }
}
