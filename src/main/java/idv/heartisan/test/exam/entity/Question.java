package idv.heartisan.test.exam.entity;

import lombok.Data;

/**
 * 题目实体
 *
 * @author Jin Qi
 * @date 2022/7/21
 */

@Data
public class Question {

    /**
     * 题目ID
     */
    private Long id;

    /**
     * 试卷 ID
     */
    private Long examId;

    /**
     * 题目内容
     */
    private String content;

    /**
     * 预期答案
     */
    private String expectedValue;
}
