package com.sam.shirotest.shirotest.encryption;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * 加密认证测试
 *
 * @since 2019-08-20
 */
public class CustomRealmTest {

    @Test
    public void testCustomRealm() {

        CustomRealm customRealm = new CustomRealm();

        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(customRealm);

        // 加密  类似于将用户输入的密码转换成MD5码，与数据库中的MD5进行比对
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        // 设置加密算法名称
        matcher.setHashAlgorithmName("MD5");
        // 设置加密次数
        matcher.setHashIterations(1);
        // 自定义Realm中设置加密的对象
        customRealm.setCredentialsMatcher(matcher);

        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("yuqiufu", "1234567");
        subject.login(token);

        System.out.println("isAuthenticated：" + subject.isAuthenticated());


    }
}
