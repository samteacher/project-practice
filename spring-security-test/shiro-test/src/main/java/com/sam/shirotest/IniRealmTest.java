package com.sam.shirotest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * IniRealm测试类
 * 自定义Realm
 *
 * @since 2019-08-18
 */
public class IniRealmTest {

    @Test
    public void testAuthorizer() {

        // 自定义
        IniRealm iniRealm = new IniRealm("classpath:user.ini");

        // 创建 Security环境
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        // 将Realm设置到Security环境中
        securityManager.setRealm(iniRealm);

        // 主体提交授权到Security
        SecurityUtils.setSecurityManager(securityManager);
        // 获取主体 SecurityUtils获取主体的工具类
        Subject subject = SecurityUtils.getSubject();

        // 认证数据
        UsernamePasswordToken token = new UsernamePasswordToken("keke", "123456");
        subject.login(token);

        System.out.println("isAuthentcated：" + subject.isAuthenticated());

        // 验证角色
        // Subject does not have role [admin1]
        subject.checkRole("admin");

        // 验证权限
        // Subject does not have permission [user:save]
//        subject.checkPermission("user:query");
        subject.checkPermissions("user:query","user:delete");
    }

}
