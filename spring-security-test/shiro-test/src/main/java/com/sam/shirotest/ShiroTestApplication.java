package com.sam.shirotest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ShiroTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroTestApplication.class, args);
    }

    @RequestMapping("/get")
    public String getString() {
        return "Hello World!@";
    }

}
