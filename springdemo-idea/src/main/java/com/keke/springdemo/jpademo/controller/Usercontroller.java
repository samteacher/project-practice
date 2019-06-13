package com.keke.springdemo.jpademo.controller;

import com.keke.springdemo.jpademo.config.UserRepository;
import com.keke.springdemo.jpademo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yuqiufu
 * @since 2019-06-13
 */
@RestController
public class Usercontroller {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/findList")
    public List<User> findByLastname(String lastname){
        List<User> userList = userRepository.findByLastname(lastname);
        return userList;
    }

    @GetMapping("/findUser")
    public User findByEmailAddress(String emailAddress){
        User user = userRepository.findByEmailAddress(emailAddress);
        return user;
    }

}
