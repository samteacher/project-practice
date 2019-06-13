package com.keke.springdemo.jpademo.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @author yuqiufu
 * @since 2019-06-13
 */
@Entity
@NamedQuery(name = "User.findByEmailAddress", query = "select u from User u where u.emailAddress = ?1")

// 注：定义多个时使用下面的注解
//@NamedQueries(value = {
//    @NamedQuery(name = User.QUERY_FIND_BY_LOGIN, query = "select u from User u where u." + User.PROP_LOGIN + " = :username"),
//    @NamedQuery(name = "getUsernamePasswordToken", query = "select new com.aceona.weibo.vo.TokenBO(u.username,u.password) from User u where u." + User.PROP_LOGIN + " = :username")})
public class User {

    private String firstname;

    private String lastname;

}
