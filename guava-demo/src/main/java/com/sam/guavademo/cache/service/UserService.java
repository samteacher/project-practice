package com.sam.guavademo.cache.service;

import com.sam.guavademo.cache.dao.UserMapper;
import com.sam.guavademo.cache.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUsers() {
        return userMapper.getUsers();
    }

    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Cacheable(value = "user", key = "#userName")
    public List<User> getUsersByName(String userName) {
        List<User> users = userMapper.getUsersByName(userName);
        System.out.println("从数据库读取，而非读取缓存！");
        return users;
    }

}
