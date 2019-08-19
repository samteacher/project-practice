package com.sam.shirotest.test;

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
 * shiro认证过程
 * 通过 Authenticate 进行认证
 */
public class AuthenticationTest {

    // 定义Realm
    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    @Before
    public void addUser() {
        simpleAccountRealm.addAccount("yuqiufu", "123456");
    }

    @Test
    public void testAuthenbtication() {

        // 1.构建SecurityManager（会话管理）环境
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(simpleAccountRealm);

        // 2.主体提交认证请求
        // 设置会话环境
        SecurityUtils.setSecurityManager(securityManager);
        // 获取主体 SecurityUtils获取主体的工具类
        Subject subject = SecurityUtils.getSubject();

        // 认证数据
        UsernamePasswordToken token = new UsernamePasswordToken("yuqiufu", "123456");

        // 登录认证
        subject.login(token);
        System.out.println("isAuthentcated：" + subject.isAuthenticated());

        // 退出
        subject.logout();
        System.out.println("isAuthentcated：" + subject.isAuthenticated());
    }
}
