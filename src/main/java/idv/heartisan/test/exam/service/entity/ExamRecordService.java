package idv.heartisan.test.exam.service.entity;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import idv.heartisan.test.exam.assembler.ExamRecordAssembler;
import idv.heartisan.test.exam.dao.dmo.ExamRecordDMO;
import idv.heartisan.test.exam.dao.mapper.ExamRecordDMOMapper;
import idv.heartisan.test.exam.entity.ExamRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

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
        LambdaQueryWrapper<ExamRecordDMO> condition = new QueryWrapper<ExamRecordDMO>()
                .lambda()
                .eq(ExamRecordDMO::getStuNum, stuNum);
        ExamRecordDMO examRecordDMO = examRecordDMOMapper.selectOne(condition);
        return examRecordDMO != null;
    }

    public BigInteger newExamRecord(ExamRecord examRecord) {
        ExamRecordDMO examRecordDMO = ExamRecordAssembler.convert(examRecord);
        examRecordDMOMapper.insert(examRecordDMO);
        return examRecordDMO.getId();
    }

    public ExamRecord getByStuNumAndExamId(String stuNum, Long examId) {
        LambdaQueryWrapper<ExamRecordDMO> condition = new QueryWrapper<ExamRecordDMO>()
                .lambda()
                .eq(ExamRecordDMO::getStuNum, stuNum)
                .eq(ExamRecordDMO::getExamId, examId);
        ExamRecordDMO examRecordDMO = examRecordDMOMapper.selectOne(condition);
        if (examRecordDMO == null) {
            return null;
        }
        return ExamRecordAssembler.convert(examRecordDMO);
    }

}
