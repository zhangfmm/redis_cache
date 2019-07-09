package com.zfm.redis_cache.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zfm
 * @since 2019-06-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TilloUserSetting implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 密保问题
     */
    private String question;

    /**
     * 密保答案
     */
    private String answers;

    /**
     * 是否开启好友验证
     */
    private Boolean verification;

    /**
     * 添加好友验证码
     */
    private String addFriendCode;

    /**
     * 删除标识，0表示未删除，1表示删除
     */
    private Boolean delFlag;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    /**
     * 更新时间
     */
    private LocalDateTime updateDate;


}
