package com.sam.shirotest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * IniRealm测试类
 */
public class IniRealmTest {

    @Test
    public void testAAuthorizer() {

        IniRealm iniRealm = new IniRealm("classpath:user.ini");

        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(iniRealm);

        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("yuqiufu", "123456");
        subject.login(token);

        System.out.println("isAuthentcated：" + subject.isAuthenticated());

    }

}
