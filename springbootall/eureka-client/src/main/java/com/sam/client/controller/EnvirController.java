package com.sam.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuqiufu
 * @since 2019-06-17
 */
@RestController
@RequestMapping("/enr")
public class EnvirController {

    @Autowired
    Environment environment;

    @GetMapping("/getEnvironment")
    public String getEnvirController() {
        System.out.println(environment.getProperty("server.port") + "============");
        return environment.getProperty("server.port");
    }

}
