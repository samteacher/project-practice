package com.keke.springdemo.jpademo.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * @author yuqiufu
 * @since 2019-06-13
 */
//@NamedQuery(name = "User.findByEmailAddress", query = "select u from User u where u.emailAddress = ?1")

// 注：定义多个时使用下面的注解
//@NamedQueries(value = {
//    @NamedQuery(name = User.QUERY_FIND_BY_LOGIN, query = "select u from User u where u." + User.PROP_LOGIN + " = :username"),
//    @NamedQuery(name = "getUsernamePasswordToken", query = "select new com.aceona.weibo.vo.TokenBO(u.username,u.password) from User u where u." + User.PROP_LOGIN + " = :username")})
@Entity
@Table(name = "user")
@Data
//@Component // 这里加上Component是为是装载Bean，获取到配置文件中的元素
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private int age;

    private String email;

    private String address;

//    @Value("${spring.datasource.username}")
//    private String username;
//
//    @Value("${spring.datasource.url}")
//    private String url;

}





