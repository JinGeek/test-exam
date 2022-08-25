package idv.heartisan.test.exam.assembler;

import idv.heartisan.test.exam.dao.dmo.ExamRecordDMO;
import idv.heartisan.test.exam.entity.ExamRecord;
import idv.heartisan.test.exam.pojo.dto.req.FakeExaminationDTO;
import idv.heartisan.test.exam.pojo.dto.resp.ExamScoreDTO;
import idv.heartisan.test.exam.utils.DozerUtil;

/**
 * @author Jin Qi
 * @date 2022/8/17
 */
public class ExamRecordAssembler {

    public static ExamRecord convert(FakeExaminationDTO fakeExaminationDTO) {
        return DozerUtil.map(fakeExaminationDTO, ExamRecord.class);
    }

    public static ExamRecordDMO convert(ExamRecord examRecord) {
        return DozerUtil.map(examRecord, ExamRecordDMO.class);
    }

    public static ExamRecord convert(ExamRecordDMO examRecordDMO) {
        return DozerUtil.map(examRecordDMO, ExamRecord.class);
    }

    public static ExamScoreDTO convertToScoreDTO(ExamRecord examRecord) {
        ExamScoreDTO examScoreDTO = new ExamScoreDTO();
        examScoreDTO.setScore(examRecord.getScore());
        examScoreDTO.setGrade(examRecord.getGrade());
        return examScoreDTO;
    }
}
