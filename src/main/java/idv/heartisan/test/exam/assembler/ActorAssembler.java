package idv.heartisan.test.exam.assembler;

import cn.hutool.crypto.digest.BCrypt;
import idv.heartisan.test.exam.dao.dmo.ActorDMO;
import idv.heartisan.test.exam.entity.Actor;
import idv.heartisan.test.exam.utils.DozerUtil;

/**
 * @author Jin Qi
 * @date 2022/8/8
 */
public class ActorAssembler {

    public static ActorDMO convert(Actor actor) {
        ActorDMO actorDMO = DozerUtil.map(actor, ActorDMO.class);
        // 密码加密
        actorDMO.setPassword(BCrypt.hashpw(actorDMO.getPassword()));
        return actorDMO;
    }
}
