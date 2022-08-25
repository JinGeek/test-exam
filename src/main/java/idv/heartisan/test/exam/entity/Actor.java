package idv.heartisan.test.exam.entity;

import idv.heartisan.test.exam.enums.ActorTypeEnum;
import lombok.Data;

import java.util.Date;

/**
 * 系统用户
 *
 * @author Jin Qi
 * @date 2022/7/22
 */

@Data
public class Actor {

    /**
     * 用户 ID
     */
    private Long actorId;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 用户类型
     */
    private ActorTypeEnum actorType;

    /**
     * 密码
     */
    private String password;

    /**
     * 添加用户实体的准备工作：
     * 1. 分配用户 ID
     */
    public void preparation() {
        this.actorId = System.currentTimeMillis();
    }

}
