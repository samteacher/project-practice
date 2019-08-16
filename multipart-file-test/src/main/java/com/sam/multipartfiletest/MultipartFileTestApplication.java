package com.sam.multipartfiletest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 图片上传项目
 */
@SpringBootApplication
@RestController
public class MultipartFileTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultipartFileTestApplication.class, args);
    }

    @GetMapping("/get")
    public String getString(){
        return " Hello world!!!!@@ ";
    }

}
