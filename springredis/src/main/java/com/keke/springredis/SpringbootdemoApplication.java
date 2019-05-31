package com.keke.springredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SpringbootdemoApplication {

    public static void main(String[] args) {
        System.getProperties().put("projectName", "springApp");
        SpringApplication.run(SpringbootdemoApplication.class, args);
    }

}
