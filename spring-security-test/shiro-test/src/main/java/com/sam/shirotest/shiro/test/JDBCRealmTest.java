package com.sam.shirotest.shiro.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * IniRealm测试类
 * 自定义Realm
 *
 * @since 2019-08-18
 */
public class JDBCRealmTest {

    DruidDataSource dataSource = new DruidDataSource();
    {
        dataSource.setUrl("jdbc:mysql://47.106.171.250:3306/flower_doctor_d2b");
        dataSource.setUsername("root");
        dataSource.setPassword("Yongsheng@2018");
    }

    @Test
    public void testJDBCRealm() {

        // 创建一个JDBCRealm对象
        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setDataSource(dataSource);
        jdbcRealm.setPermissionsLookupEnabled(true);//设置权限开关，默认是false

        // 在没有定义我们自己写的SQL语句时;会一直报错  table 'users' dont exit;
        // protected static final String DEFAULT_AUTHENTICATION_QUERY = "select password from users where username = ?";
        // JDBCREALM中有自己的SQL语句，当我们想使用自己定义的sql语句时;使用下面的方法;
        String sql = " select passWord from sysuserinfo where accountNumber = ? ";
        jdbcRealm.setAuthenticationQuery(sql);

//        jdbcRealm.setAuthenticationQuery(String sql) // 该方法设置身份验证的sql语句
//        jdbcRealm.setUserRolesQuery(String sql) // 该方法设置角色验证的sql语句
//        jdbcRealm.setPermissionsQuery(String sql) // 该方法设置权限验证的sql语句。


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

    }

}
