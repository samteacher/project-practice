package com.sam.guavademo.cache.controller;

import com.sam.guavademo.cache.entity.User;
import com.sam.guavademo.cache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    CacheManager cacheManager;

    @GetMapping("/get")
    public List<User> geUsersByName(String userName) {
        System.out.println("-------------------------------------------");
        System.out.println("call /getusersbyname");
        System.out.println(cacheManager.toString());
        List<User> users = userService.getUsersByName(userName);
        return users;
    }

}
