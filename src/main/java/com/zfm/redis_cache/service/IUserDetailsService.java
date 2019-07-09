package com.zfm.redis_cache.service;

import com.zfm.redis_cache.entity.UserDetails;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zfm
 * @since 2019-06-28
 */
public interface IUserDetailsService extends IService<UserDetails> {

    UserDetails getUserDetailsByUid(int uid);

    UserDetails updateUserInfo(UserDetails userDetails);

    int delUserInfoById(int uid);

}
