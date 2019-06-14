package com.keke.springdemo.redisOrCache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuqiufu
 * @since 2019-06-14
 */
@RestController
public class RedisController {

    @Autowired
    StringRedisTemplate redisTemplate;

    @GetMapping("set/{key}/{value}")
    public String set(@PathVariable("key")String key, @PathVariable("value") String value) {
        redisTemplate.opsForValue().set(key, value);
        return key + "---" + value;
    }

    @GetMapping("get/{key}")
    public String get(@PathVariable("key") String key) {
        return "key=" + key + ",value=" + redisTemplate.opsForValue().get(key);
    }

}
