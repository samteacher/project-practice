package com.keke.maven.service;

import com.keke.maven.entity.User;
import com.keke.maven.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuqiufu
 * @since 2019-06-11
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 保存用户信息
     *
     * @param user
     * @return
     */
    public boolean saveUser(User user) {
        return userMapper.saveUser(user);
    }

    /**
     * 查询用户信息
     *
     * @return
     */
    public List<User> findUser() {
        return userMapper.findUser();
    }

}
