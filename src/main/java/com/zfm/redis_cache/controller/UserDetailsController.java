package com.zfm.redis_cache.controller;


import com.zfm.redis_cache.entity.UserDetails;
import com.zfm.redis_cache.service.IUserDetailsService;
import com.zfm.redis_cache.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zfm
 * @since 2019-06-28
 */
@RestController
@RequestMapping("/user-details")
public class UserDetailsController {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    @GetMapping("/get")
    public void aa() {
        UserDetails userDetails = userDetailsService.getUserDetailsByUid(1);
        System.out.println(userDetails);

    }

    public static void main(String[] args) {
        List<Long> abc=new ArrayList<>();
    }
}
