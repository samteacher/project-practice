package com.sam.guavademo.cache.dao;

import com.sam.guavademo.cache.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yuqiufu
 * @since 2019-05-15
 */
@Mapper
public interface UserMapper {

    List<User> getUsers();

    int addUser(User user);

    List<User> getUsersByName(String userName );

}
