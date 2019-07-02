package com.sam.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuqiufu
 * @since 2019-06-17
 */
@RestController
public class ProviderController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.application.name}")
    private String applicationName;

    private static int count = 0;

    @RequestMapping("/getProviderAll")
    public List<String> getMemberAll() {
        count++;
        List<String> listUser = new ArrayList<String>();
        listUser.add("zhangsan");
        listUser.add("lisi");
        listUser.add("wangwu");
        listUser.add("count=" + count);
        listUser.add("serverPort===" + serverPort);
        listUser.add("applicationName==" + applicationName);
        return listUser;
    }

    @GetMapping("/getClientServiceApi")
    public String getClientServiceApi(){
        return "this is 提供者";
    }

}
