package com.sam.guavademo.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author yuqiufu
 * @desc 缓存值定时刷新
 * @since 2019-05-15
 */
public class RefreshAfterWriteDemo {

    /**
     * 《缓存值定时刷新》
     * 更新线程调用load方法更新该缓存，其他请求线程返回该缓存的旧值
     * 这样对于某个key的缓存来说，只会有一个线程被阻塞，用来生成缓存值，而其他的线程都返回旧的缓存值，不会被阻塞
     *
     * @param args
     */
    public static void main(String[] args) {

        LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(100)
                // 缓存值定时刷新 时间5s
                .refreshAfterWrite(5, TimeUnit.SECONDS)
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        return "load key was：" + key;
                    }
                });

        try {
            System.out.println(cache.getIfPresent("cache-value"));
            System.out.println(cache.get("cache-value"));

        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
