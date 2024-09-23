package idv.heartisan.test.exam.domain.service;

import idv.heartisan.test.exam.assembler.ExamRecordAssembler;
import idv.heartisan.test.exam.dao.dmo.ExamRecordDMO;
import idv.heartisan.test.exam.dao.mapper.ExamRecordDMOMapper;
import idv.heartisan.test.exam.domain.entity.ExamRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

import static idv.heartisan.test.exam.dao.def.ExamRecordTableDef.EXAM_RECORD_D_M_O;

/**
 * @author Jin Qi
 * @date 2022/8/17
 */

@Service
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS)
public class ExamRecordService {

    @Autowired
    private ExamRecordDMOMapper examRecordDMOMapper;

    public boolean isExamined(String stuNum) {
        ExamRecordDMO examRecordDMO = examRecordDMOMapper.selectOneByCondition(EXAM_RECORD_D_M_O.STU_NUM.eq(stuNum));
        return examRecordDMO != null;
    }

    public BigInteger newExamRecord(ExamRecord examRecord) {
        ExamRecordDMO examRecordDMO = ExamRecordAssembler.convert(examRecord);
        examRecordDMOMapper.insert(examRecordDMO);
        return examRecordDMO.getId();
    }

    public ExamRecord getByStuNumAndExamId(String stuNum, Long examId) {
        ExamRecordDMO examRecordDMO = examRecordDMOMapper.selectOneByCondition(EXAM_RECORD_D_M_O.STU_NUM.eq(stuNum).and(EXAM_RECORD_D_M_O.EXAM_ID.eq(examId)));
        if (examRecordDMO == null) {
            return null;
        }
        return ExamRecordAssembler.convert(examRecordDMO);
    }

}
