package com.zfm.redis_cache.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author zfm
 * @since 2019-06-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TilloUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 用户名字
     */
    private String name;

    /**
     * 用户性别  0 男  1女
     */
    private Boolean sex;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 国际区号
     */
    @TableField("dialCode")
    private Long dialCode;

    /**
     * 用户手机
     */
    private Long mobile;

    /**
     * 介绍
     */
    private String introduce;

    /**
     * 国家
     */
    private String country;

    /**
     * 地区
     */
    private String region;

    /**
     * 地址
     */
    private String address;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 注册IP
     */
    private String registerIp;

    /**
     * 登陆ip
     */
    private String loginIp;

    /**
     * 平台（1：android 2：ios 3：web）
     */
    private Integer platform;

    /**
     * 最后登陆平台（1：android 2：ios 3：web）
     */
    private Integer lastPlatform;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 设备token(anroid：信鸽/firebase ，ios：apns)
     */
    private String deviceToken;

    /**
     * 手机唯一设备id
     */
    private String deviceId;

    /**
     * 最后登陆时间
     */
    private LocalDateTime lastLoginDate;

    /**
     * 身份token
     */
    private String token;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    /**
     * 更新时间
     */
    private LocalDateTime updateDate;

    /**
     * 删除标识
     */
    private Boolean delFlag;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 手机品牌 （默认 0 普通 ，1 华为 ）
     */
    private Integer brand;

    private String question;

    private String answers;


}
