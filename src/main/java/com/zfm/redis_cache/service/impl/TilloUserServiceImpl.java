package com.zfm.redis_cache.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zfm.redis_cache.entity.TilloUser;
import com.zfm.redis_cache.mapper.TilloUserMapper;
import com.zfm.redis_cache.service.ITilloUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author zfm
 * @since 2019-06-28
 */
@Service
public class TilloUserServiceImpl extends ServiceImpl<TilloUserMapper, TilloUser> implements ITilloUserService {

    @Override
    public List<TilloUser> findAllTilloUser() {
        return baseMapper.selectList(null);
    }
}
