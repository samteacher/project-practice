package com.sam.shirotest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.mgt.SecurityManager;
import org.junit.Before;
import org.junit.Test;

/**
 * 测试类
 * shiro
 */
public class AuthenticationTest {

    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    @Before
    public void addUser(){
        simpleAccountRealm.addAccount("keke","123456", "admin","user");
    }

    @Test
    public void testAuthenbtication() {

        // 1.构建SecurityManager（会话管理）环境
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(simpleAccountRealm);

        // 2.主体提交认证请求
        // 设置会话环境
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        // 认证
        UsernamePasswordToken token = new UsernamePasswordToken("keke","123456");
        // 登录
        subject.login(token);
        System.out.println("isAuthentcated：" + subject.isAuthenticated());

        subject.checkRoles("admin","user");

        // 退出
//        subject.logout();
//        System.out.println("isAuthentcated：" + subject.isAuthenticated());
    }
}
