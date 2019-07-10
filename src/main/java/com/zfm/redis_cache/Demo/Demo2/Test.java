package com.zfm.redis_cache.Demo.Demo2;

/**
 * @author zfm
 * @Description TODO
 * @date 2019/7/9
 */
public class Test {
    public static void main(String[] args) {
        final int start = Integer.MAX_VALUE - 100;
        final int end = Integer.MAX_VALUE;
        int count = 0;
        for (int i = start; i <= end; i++)
            count++;
        System.out.println(count);
    }
}
