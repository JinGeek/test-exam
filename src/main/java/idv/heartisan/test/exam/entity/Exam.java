package idv.heartisan.test.exam.entity;

import lombok.Data;

import java.util.List;

/**
 * 试卷
 *
 * @author Jin Qi
 * @date 2022/7/21
 */
@Data
public class Exam {

    /**
     * 试卷 ID
     */
    private Long id;

    /**
     * 试卷名称
     */
    private String name;

    /**
     * 创建人
     */
    private String teacherNum;

    /**
     * 试题
     */
    private List<Question> questions;
}
