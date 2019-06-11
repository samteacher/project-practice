package com.keke.maven.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yuqiufu
 * @since 2019-06-11
 */
@Data
public class User implements Serializable {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 地址
     */
    private String address;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 创建时间
     */
    private Date createTime;

}
