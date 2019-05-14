package com.sam.springbootjedis.test;

import com.sam.springbootjedis.config.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
public class RedisController {

    @Autowired
    RedisService redisService;

    @GetMapping("/test")
    public void set(String key, String str) {
        redisService.set(key, str);
    }

    @GetMapping("/del")
    public void del(String key) {
        redisService.del(key);
    }

    @GetMapping("/get")
    public String get(String key) {
        return redisService.get(key);
    }

}
