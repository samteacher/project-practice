package com.sam.guavademo.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

/**
 * @author yuqiufu
 * @desc 加载缓存  当找不到key的时候定义加载
 * @since 2019-05-15
 */
public class LoadCache {

    public static void main(String[] args) {

        LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(10, TimeUnit.SECONDS)
                .build(new CacheLoader<String, String>() {
                           @Override
                           public String load(String key) throws Exception {
                               System.out.println("load key ：" + key);
                               return key + " ：value";
                           }
                       }
                );

        // 当找不到key的时候定义加载
        // cache.put("hello","world");

        /**
         * 第一次get时候通过load方法加载，第二次get时候走的就load自动加载的缓存
         */
        System.out.println(cache.getUnchecked("hello"));
        System.out.println(cache.getUnchecked("hello"));

    }
}
