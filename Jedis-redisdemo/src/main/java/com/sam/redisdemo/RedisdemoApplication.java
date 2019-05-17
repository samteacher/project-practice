package com.sam.redisdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(com.sam.redisdemo.config.RedisConfig.class)
public class RedisdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisdemoApplication.class, args);
    }

}
