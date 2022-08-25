package idv.heartisan.test.exam.assembler;

import idv.heartisan.test.exam.dao.dmo.ExamDMO;
import idv.heartisan.test.exam.entity.Exam;
import idv.heartisan.test.exam.pojo.dto.req.ExamCreationDTO;
import idv.heartisan.test.exam.utils.DozerUtil;

/**
 * @author Jin Qi
 * @date 2022/8/11
 */
public class ExamAssembler {

    public static Exam convert(ExamCreationDTO examCreationDTO) {
        return DozerUtil.map(examCreationDTO, Exam.class);
    }

    public static ExamDMO convert(Exam exam) {
        return DozerUtil.map(exam, ExamDMO.class);
    }

    public static Exam convert(ExamDMO examDMO) {
        return DozerUtil.map(examDMO, Exam.class);
    }
}
