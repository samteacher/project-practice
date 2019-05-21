package com.sam.redisdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootApplication
@Import(com.sam.redisdemo.config.RedisConfig.class)
public class RedisdemoApplication {

    public static void main(String[] args) {

        ApplicationContext ct = SpringApplication.run(RedisdemoApplication.class, args);

        StringRedisTemplate template = ct.getBean(StringRedisTemplate.class);
        template.convertAndSend("messagepush", "Hello message!");
        template.convertAndSend("messagepush3", "Hello message3 !");
    }

}
