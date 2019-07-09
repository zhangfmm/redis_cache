package com.zfm.redis_cache.service;

import com.zfm.redis_cache.entity.TilloUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author zfm
 * @since 2019-06-28
 */
public interface ITilloUserService extends IService<TilloUser> {

    List<TilloUser> findAllTilloUser();

}
