package com.sam.shirotest.encryption;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * 加密测试
 *
 * @since 2019-08-20
 */
public class CustomRealmTest {

    @Test
    public void testCustomRealm() {

        CustomRealm customRealm = new CustomRealm();

        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(customRealm);

        // 加密
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


    }
}
