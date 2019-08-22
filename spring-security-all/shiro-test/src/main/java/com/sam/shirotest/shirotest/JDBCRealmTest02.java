package com.sam.shirotest.shirotest;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

/**
 * IniRealm测试类
 * 自定义Realm
 *
 * @since 2019-08-18
 */
public class JDBCRealmTest02 {

    // 创建一个JDBCRealm对象
    private JdbcRealm jdbcRealm = new JdbcRealm();

    private DruidDataSource dataSource = new DruidDataSource();

    @Before
    public void JDBCRealmSet() {
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        jdbcRealm.setDataSource(dataSource);
        jdbcRealm.setPermissionsLookupEnabled(true);
    }

    @Test
    public void testJDBCRealm() {

        //1、构建SecurityManager环境
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        // 将Realm设置到Security环境中
        securityManager.setRealm(jdbcRealm);

        //2、主体提交认证请求
        SecurityUtils.setSecurityManager(securityManager);
        // 获取主体 SecurityUtils获取主体的工具类
        Subject subject = SecurityUtils.getSubject();

        // 认证数据
        UsernamePasswordToken token = new UsernamePasswordToken("admin", "admin");
        subject.login(token);

        System.out.println("isAuthentcated：" + subject.isAuthenticated());

        //查看是否有角色
        System.out.println(subject.hasRole("user"));//true
        //查看是否有权限
        System.out.println(subject.isPermitted("user:select"));//true
        subject.checkPermission("user:select");


    }

}
