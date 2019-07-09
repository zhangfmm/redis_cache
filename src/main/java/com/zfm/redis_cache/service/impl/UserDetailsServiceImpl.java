package com.zfm.redis_cache.service.impl;

import com.zfm.redis_cache.entity.UserDetails;
import com.zfm.redis_cache.mapper.UserDetailsMapper;
import com.zfm.redis_cache.service.IUserDetailsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zfm
 * @since 2019-06-28
 */
@Service
public class UserDetailsServiceImpl extends ServiceImpl<UserDetailsMapper, UserDetails> implements IUserDetailsService {

    @Override
    @Cacheable(value = "user_details", key = "#uid", unless = "#result == null")
//    @Cacheable(key = "('s')+#p0")
    public UserDetails getUserDetailsByUid(int uid) {
        System.out.println(" Cacheable 有请求过来了");
        UserDetails userDetails = baseMapper.selectById(uid);
        return userDetails;
    }

    @Override
    @CachePut(value = "user_details", key = "#user.id")
    public UserDetails updateUserInfo(UserDetails user) {
        System.out.println(" CachePut 有请求过来了");
        if (baseMapper.updateById(user) > 0) {
            // 这里也可以直接在updateByPrimaryKeySelective的方法里，修改后直接查询出该记录返回UserDetails实例，看需求。
            user = baseMapper.selectById(user.getId());
            return user;
        } else {
            return null;
        }
    }

    @Override
    @CacheEvict(value = "user_details", key = "#uid")
    public int delUserInfoById(int uid) {
        System.out.println(" CacheEvict 有请求过来了");
        return baseMapper.deleteById(uid);
    }

}
