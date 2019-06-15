package com.keke.springdemo.redisOrCache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuqiufu
 * @since 2019-06-14
 */
@RestController
public class RedisController {

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 添加
     *
     * @param key
     * @param value
     * @return
     * @date 2019-06-15
     */
    @CachePut(value = "people", key = "#value")
    @Transactional(rollbackFor = Exception.class)
    @GetMapping("/set")
    public String set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
        return key + "---" + value;
    }

    /**
     * 查询
     *
     * @param key
     * @return
     * @date 2019-06-15
     */
    @Cacheable(value = "admin", key = "#key")
    @GetMapping("/get")
    public String get(String key) {
        return "key=" + key + ",value=" + redisTemplate.opsForValue().get(key);
    }

    /**
     * 更新时 直接删除缓存 以保证下次获取时先从数据库中获取最新数据
     *
     * @param key
     * @date 2019-06-15
     */
    @CacheEvict(value = "admin", key = "#key")
    @GetMapping("/del")
    public void delete(String key) {
        redisTemplate.delete(key);
    }

}
