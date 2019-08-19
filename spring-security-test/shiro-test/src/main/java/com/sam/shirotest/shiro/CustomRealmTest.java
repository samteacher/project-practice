package com.sam.shirotest.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * 自定义Realm测试
 *
 * @since 2019-08-19
 */
public class CustomRealmTest {

    @Test
    public void testCustomRealm() {

        CustomRealm customRealm = new CustomRealm();

        //1、构建SecurityManager环境
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        // 将Realm设置到Security环境中
        securityManager.setRealm(customRealm);

        //2、主体提交认证请求
        SecurityUtils.setSecurityManager(securityManager);
        // 获取主体 SecurityUtils获取主体的工具类
        Subject subject = SecurityUtils.getSubject();

        // 认证数据
        UsernamePasswordToken token = new UsernamePasswordToken("yuqiufu", "123456");
        subject.login(token);

        System.out.println("isAuthentcated：" + subject.isAuthenticated());
        subject.checkRoles("admin", "user");
        subject.checkPermissions("admin:delete", "user:select");

        // 查看是否有角色
        System.out.println("isHasRole：" + subject.hasRole("admin"));//true
        System.out.println("isHasRole：" + subject.hasRole("user"));//true
        //查看是否有权限
        System.out.println("isPermitted：" + subject.isPermitted("admin:delete"));//true
        System.out.println("isPermitted：" + subject.isPermitted("user:select"));//true

    }
}
