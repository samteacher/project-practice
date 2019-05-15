package com.sam.guavademo.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author yuqiufu
 * @desc Guava的回收机制  expireAfterAccess 缓存项在给定时间内没有被读/写访问，则回收
 * @since 2019-05-15
 */
public class ExpireAfterAccessCache {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                // 缓存项在给定时间内没有被读/写访问，则回收
                .expireAfterAccess(2, TimeUnit.SECONDS)
                // 缓冲过期时间
                .expireAfterWrite(1, TimeUnit.SECONDS)
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        System.out.println("load key is " + key);
                        return key;
                    }
                });

        /**
         * 无缓存数据时,load自动加载数据  打印结果：
         * load key is 笔记本
         * 笔记本
         * load key is 红酒
         * 红酒
         * load key is 筷子
         * 筷子
         * 面包-->null
         */
        cache.put("面包","3元");
        cache.put("笔记本","15元");
        cache.put("红酒","148元");

        System.out.println(cache.get("笔记本"));
        System.out.println(cache.get("红酒"));
        System.out.println(cache.get("筷子"));

        Thread.sleep(1000 * 2);

        /**
         * 注释后：没有调用“面包”时 getIfPresent为null
         */
//        System.out.println(cache.get("面包"));

        // 查看是否在给定时间内没有被读/写访问时回收
        System.out.println("面包-->" + cache.getIfPresent("面包"));

    }
}
