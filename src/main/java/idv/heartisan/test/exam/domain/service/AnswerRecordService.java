package idv.heartisan.test.exam.domain.service;

import idv.heartisan.test.exam.assembler.AnswerRecordAssembler;
import idv.heartisan.test.exam.dao.def.AnswerRecordTableDef;
import idv.heartisan.test.exam.dao.dmo.AnswerRecordDMO;
import idv.heartisan.test.exam.dao.mapper.AnswerRecordDMOMapper;
import idv.heartisan.test.exam.domain.entity.AnswerRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jin Qi
 * @date 2022/8/17
 */

@Service
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS)
public class AnswerRecordService {

    @Autowired
    private AnswerRecordDMOMapper answerRecordDMOMapper;

    public void batchInsert(List<AnswerRecord> answerRecordList) {
        for (AnswerRecord answerRecord : answerRecordList) {
            AnswerRecordDMO answerRecordDMO = AnswerRecordAssembler.convert(answerRecord);
            answerRecordDMOMapper.insert(answerRecordDMO);
        }
    }

    public List<AnswerRecord> queryByExamRecordId(Long examRecordId) {
        List<AnswerRecordDMO> answerRecordDMOList = answerRecordDMOMapper.selectListByCondition(AnswerRecordTableDef.ANSWER_RECORD_D_M_O.EXAM_RECORD_ID.eq(examRecordId));
        List<AnswerRecord> answerRecordList = new ArrayList<>();
        for (AnswerRecordDMO answerRecordDMO : answerRecordDMOList) {
            AnswerRecord answerRecord = AnswerRecordAssembler.convert(answerRecordDMO);
            answerRecordList.add(answerRecord);
        }
        return answerRecordList;
    }
}
