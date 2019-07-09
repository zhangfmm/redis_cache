package com.zfm.redis_cache.controller;


import com.zfm.redis_cache.entity.TilloUser;
import com.zfm.redis_cache.entity.TilloUserSetting;
import com.zfm.redis_cache.service.ITilloUserService;
import com.zfm.redis_cache.service.ITilloUserSettingService;
import com.zfm.redis_cache.service.impl.TilloUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import tools.ConverUtils;
import tools.SnowflakeIdWorker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author zfm
 * @since 2019-06-28
 */
@RestController
@RequestMapping("/tillo-user")
public class TilloUserController {
    @Autowired
    private ITilloUserService tilloUserService;
    @Autowired
    private ITilloUserSettingService tilloUserSettingService;

    @GetMapping("/save")
    public void saveAllTilloUser() {
        List<TilloUser> allTilloUser = tilloUserService.findAllTilloUser();
//        List<TilloUserSetting> tilloUserSettingList = new ArrayList<>();
//        TilloUserSetting tilloUserSetting;
//        for (TilloUser tilloUser : allTilloUser) {
//            tilloUserSetting = new TilloUserSetting();
//            tilloUserSetting.setUserId(Integer.valueOf(tilloUser.getId().toString()));
//            tilloUserSetting.setQuestion(tilloUser.getQuestion());
//            tilloUserSetting.setAnswers(tilloUser.getAnswers());
//            tilloUserSetting.setId(SnowflakeIdWorker.nextId());
//            tilloUserSettingList.add(tilloUserSetting);
//
//        }

        List<TilloUserSetting> tilloUserSettingList = allTilloUser.stream().map((tilloUser) -> {
            TilloUserSetting tilloUserSetting = ConverUtils.convert(tilloUser, TilloUserSetting.class);
            return tilloUserSetting;
        }).collect(Collectors.toList());
        System.out.println(tilloUserSettingList);
        tilloUserSettingService.saveBatch(tilloUserSettingList);

    }


    private int value;

// 获取内存值

    public synchronized int get() {

        return value;

    }


// 无论更新成功与否,都返回修改之前的内存值

    public synchronized int compareAndSwap(int expectedValue, int newValue) {

// 获取旧值

        int oldValue = value;
        System.out.println("----------------------");
        System.out.println("oldValue" + oldValue);
        System.out.println("expectedValue" + expectedValue);
        System.out.println("newValue" + newValue);
        System.out.println("----------------------");

        if (oldValue == expectedValue) {

            this.value = newValue;

        }


// 返回修改之前的值

        return oldValue;

    }


// 判断是否设置成功

    public synchronized boolean compareAndSet(int expectedValue, int newValue) {

        return expectedValue == compareAndSwap(expectedValue, newValue);

    }


    public static void main(String[] args) {
        TilloUserController cas = new TilloUserController();

        for (int i = 0; i < 10; i++) {

// 创建10个线程,模拟多线程环境

            new Thread(new Runnable() {

                public void run() {

                    int expectedValue = cas.get();

                    boolean b = cas.compareAndSet(expectedValue, (int) (Math.random() * 100));

                    System.out.println(b);

                }

            }).start();


        }


    }

}


