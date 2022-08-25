package idv.heartisan.test.exam.pojo.dto.req;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Jin Qi
 * @date 2022/8/16
 */

@Data
public class FakeExaminationDTO {

    /**
     * 学号
     */
    @NotEmpty
    private String stuNum;

    /**
     * 试卷 ID
     */
    @NotNull
    private Long examId;
}
