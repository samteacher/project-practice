package com.sam.guavademo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.sam.guavademo.dao")
@EnableCaching
public class GuavaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuavaDemoApplication.class, args);
    }

}
