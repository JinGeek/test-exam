package idv.heartisan.test.exam.dao.impl;

import idv.heartisan.test.exam.dao.dmo.ActorDMO;
import idv.heartisan.test.exam.dao.mapper.ActorDMOMapper;
import idv.heartisan.test.exam.dao.ActorDAO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jin Qi
 * @since 2023-05-25
 */
@Service
public class ActorDAOImpl extends ServiceImpl<ActorDMOMapper, ActorDMO> implements ActorDAO {

}
