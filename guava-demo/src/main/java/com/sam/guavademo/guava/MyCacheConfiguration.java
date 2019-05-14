package com.sam.guavademo.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author yuqiufu
 */
@Configuration
public class MyCacheConfiguration {

    private static final int EXPIRE_SECONDS = 86400;

    /**
     * 定义token缓存, 默认最大数量为3000
     */
    @Bean
    public static LoadingCache<String, Object> myCacheStorage() {
        return CacheBuilder.newBuilder().maximumSize(3000).expireAfterWrite(EXPIRE_SECONDS, TimeUnit.SECONDS).build(new CacheLoader<String, Object>() {
            @Override
            public Object load(String key) throws Exception {
                //在这里可以初始化加载数据的缓存信息，读取数据库中信息或者是加载文件中的某些数据信息
                return key;
            }
        });
    }

}
