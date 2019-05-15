package com.sam.guavademo.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @author yuqiufu
 * @since 2019-05-15
 * <p>
 * Guava Cache简单说就是一个支持LRU的Concurrent-HashMap，它没有Ehcache那么多的特性，
 * 只是提供了增、删、改、查、刷新规则和时效规则设定等最基本的元素，同时Guava cache极度简洁又能满足大部分人的要求
 */
public class CallableCacheDemo {

    /**
     * Callable
     */
    public static void main(String[] args) throws ExecutionException {

        // 初始化
        Cache<String, String> cache = CacheBuilder
                .newBuilder()
                //设置缓存最大容量为100
                .maximumSize(100)
                .build();

        /**
         * Callable callback  这个方法返回缓存中相应的值，如果末获取到缓存值则调用Callable方法
         * 这个方法简便实现了“如果有缓存则返回，否则读取、缓存、然后返回”的模式
         */
        String resultVal = cache.get("test", new Callable<String>() {
            @Override
            public String call() throws Exception {
                String strProValue = "test-value";
                return strProValue;
            }
        });
        System.out.println("return value: " + resultVal);


        // 获取某个key时，在Cache.get中单独为其指定load方法
        resultVal = cache.get("peida", new Callable<String>() {
            @Override
            public String call() {
                String strProValue = "hello " + "peida" + "!";
                return strProValue;
            }
        });
        System.out.println("return value: " + resultVal);

    }

}
