package idv.heartisan.test.exam.dao.mapper;

import idv.heartisan.test.exam.dao.dmo.SchedulerLockDMO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 定时任务锁 Mapper 接口
 * </p>
 *
 * @author jinqi
 * @since 2023-01-19
 */
public interface SchedulerLockDMOMapper extends BaseMapper<SchedulerLockDMO> {

    @Select("select * from scheduler_lock where name = #{name} for update")
    SchedulerLockDMO getByName(String name);

}
