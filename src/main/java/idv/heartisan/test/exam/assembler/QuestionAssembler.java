package idv.heartisan.test.exam.assembler;

import idv.heartisan.test.exam.dao.dmo.QuestionDMO;
import idv.heartisan.test.exam.entity.Question;
import idv.heartisan.test.exam.pojo.dto.req.QuestionCreationDTO;
import idv.heartisan.test.exam.utils.DozerUtil;

/**
 * @author Jin Qi
 * @date 2022/8/12
 */
public class QuestionAssembler {

    public static Question convert(QuestionCreationDTO questionCreationDTO) {
        return DozerUtil.map(questionCreationDTO, Question.class);
    }

    public static QuestionDMO convert(Question question) {
        return DozerUtil.map(question, QuestionDMO.class);
    }

    public static Question convert(QuestionDMO questionDMO) {
        return DozerUtil.map(questionDMO, Question.class);
    }
}
