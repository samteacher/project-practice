package com.sam.shirotest.shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

/**
 * 测试类
 * Shiro授权
 * 通过 AuthorizerTest 授权器
 */
public class AuthorizerTest {

    // 定义Realm
    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    @Before
    public void addUser() {
        simpleAccountRealm.addAccount("yuqiufu", "123456", "admin", "user");
    }

    @Test
    public void testAAuthorizer() {

        // 1.构建SecurityManager（会话管理）环境
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(simpleAccountRealm);

        // 2.主体提交授权请求
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("yuqiufu", "123456");

        // 登录
        subject.login(token);
        System.out.println("isAuthentcated：" + subject.isAuthenticated());

        // 检查用户是否有这样的角色
        subject.checkRoles("admin", "user");

    }

}
