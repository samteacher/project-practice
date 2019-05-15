package com.sam.guavademo.guava;

import com.google.common.cache.*;

import java.util.concurrent.TimeUnit;

/**
 * @author yuqiufu
 * @desc 设置过期时间，清除缓存
 * @since 2019-05-15
 */
public class ExpirationTimeCache {

    public static void main(String[] args) throws InterruptedException {

        // 缓存构造器
        Cache<Object, Object> cache = CacheBuilder.newBuilder()
                // 过期时间5s
                .expireAfterWrite(15, TimeUnit.SECONDS)
                .build();

        cache.put("hello", "where are you");
        for (int i = 0; i <= 10; i++) {
            System.out.println("沉睡之前：" + cache.getIfPresent("hello"));
            // 沉睡8s
            Thread.sleep(1000 * 5);
            // null
            System.out.println("沉睡之后：" + cache.getIfPresent("hello"));
        }

    }

}
