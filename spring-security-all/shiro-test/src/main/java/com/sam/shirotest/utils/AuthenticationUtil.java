package com.sam.shirotest.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 认证授权封装
 *
 * @since 2019-08-21
 */
public class AuthenticationUtil {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationUtil.class);
    private static final JdbcRealm jdbcRealm = new JdbcRealm();
    private static final DruidDataSource dataSource = new DruidDataSource();

    /**
     * 链接数据库
     *
     * @return
     * @date 2019-08-21
     */
    public void getDatasource() {
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306?test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        jdbcRealm.setDataSource(dataSource);
        jdbcRealm.setPermissionsLookupEnabled(true);
    }

    /**
     * 是否认证成功
     *
     * @param token
     * @return
     * @date 2019-08-21
     */
    public static boolean getToken(UsernamePasswordToken token) {

        if (token != null) {
            DefaultSecurityManager securityManager = new DefaultSecurityManager();
            securityManager.setRealm(jdbcRealm);

            SecurityUtils.setSecurityManager(securityManager);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);

            if (subject.isAuthenticated()) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

}
