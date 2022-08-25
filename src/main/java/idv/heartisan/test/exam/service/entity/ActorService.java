package idv.heartisan.test.exam.service.entity;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import idv.heartisan.test.exam.dao.dmo.ActorDMO;
import idv.heartisan.test.exam.dao.mapper.ActorDMOMapper;
import idv.heartisan.test.exam.entity.Actor;
import idv.heartisan.test.exam.enums.ErrorEnum;
import idv.heartisan.test.exam.exceptions.BizException;
import idv.heartisan.test.exam.assembler.ActorAssembler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jin Qi
 * @date 2022/8/5
 */
@Service
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS)
public class ActorService {

    @Autowired
    private ActorDMOMapper actorDMOMapper;

    public void newActor(Actor actor) {
        validate(actor);

        actor.preparation();
        ActorDMO actorDMO = ActorAssembler.convert(actor);
        actorDMOMapper.insert(actorDMO);
    }

    public void validate(Actor actor) {
        if (actor == null) {
            throw new BizException(ErrorEnum.OBJECT_NOT_NULL);
        }

        LambdaQueryWrapper<ActorDMO> condition = new QueryWrapper<ActorDMO>()
                .lambda()
                .eq(ActorDMO::getPhone, actor.getPhone());
        Long count = actorDMOMapper.selectCount(condition);
        if (count > 0) {
            log.error("手机号重复: {}", actor.getPhone());
            throw new BizException(ErrorEnum.PHONE_NUM_DUPLICATION);
        }
    }
}
