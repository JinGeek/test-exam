package idv.heartisan.test.exam.dao.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import idv.heartisan.test.exam.dao.dmo.ActorDMO;
import idv.heartisan.test.exam.dao.mapper.ActorDMOMapper;
import idv.heartisan.test.exam.dao.ActorDAO;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author heartisan
 * @since 2023-11-29
 */
@Service
public class ActorDAOImpl extends ServiceImpl<ActorDMOMapper, ActorDMO> implements ActorDAO {

}
