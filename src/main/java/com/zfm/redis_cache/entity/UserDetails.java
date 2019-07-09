package com.zfm.redis_cache.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

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
public class UserDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String introduce;

    private String delFlag;

    private Timestamp createDate;

    private Timestamp updateDate;


}
