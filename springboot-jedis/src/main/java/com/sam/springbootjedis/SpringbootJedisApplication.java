package com.sam.springbootjedis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisReactiveAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.Assert;

@SpringBootApplication
public class SpringbootJedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJedisApplication.class, args);
    }

}
