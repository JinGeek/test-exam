package idv.heartisan.test.exam.service.entity;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import idv.heartisan.test.exam.assembler.ExamAssembler;
import idv.heartisan.test.exam.dao.dmo.ExamDMO;
import idv.heartisan.test.exam.dao.mapper.ExamDMOMapper;
import idv.heartisan.test.exam.entity.Exam;
import idv.heartisan.test.exam.enums.ErrorEnum;
import idv.heartisan.test.exam.exceptions.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jin Qi
 * @date 2022/8/11
 */

@Service
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS)
public class ExamService {

    @Autowired
    private ExamDMOMapper examDMOMapper;

    public Long newExam(Exam exam) {
        LambdaQueryWrapper<ExamDMO> condition = new QueryWrapper<ExamDMO>()
                .lambda()
                .eq(ExamDMO::getName, exam.getName());
        ExamDMO examDMO = examDMOMapper.selectOne(condition);
        if (examDMO != null) {
            throw new BizException(ErrorEnum.EXAM_NAME_DUPLICATION);
        }
        examDMO = ExamAssembler.convert(exam);
        examDMOMapper.insert(examDMO);
        return examDMO.getId();
    }

    public Exam getExamById(Long examId) {
        ExamDMO examDMO = examDMOMapper.selectById(examId);
        if (examDMO == null) {
            throw new BizException(ErrorEnum.EXAM_ID_INVALID);
        }
        return ExamAssembler.convert(examDMO);
    }
}
