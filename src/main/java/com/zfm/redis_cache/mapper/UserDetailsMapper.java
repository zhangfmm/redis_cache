package com.zfm.redis_cache.mapper;

import com.zfm.redis_cache.entity.UserDetails;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zfm
 * @since 2019-06-28
 */
public interface UserDetailsMapper extends BaseMapper<UserDetails> {

    UserDetails getUserDetailsByUid(int uid);

    int updateByPrimaryKeySelective(UserDetails user);

    int deleteByPrimaryKey(int uid);
}
