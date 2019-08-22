package com.sam.shirotest.shirotest.encryption;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 加密认证
 *
 * @since 2019-08-20
 */
public class CustomRealm extends AuthorizingRealm {

    Map<String, String> userMap = new HashMap<>(16);
    {
        // 获取用户名和密码
        userMap.put("yuqiufu", "0287040c474dbf44cdeb17eebb99d828");
        // 默认角色
        super.setName("customRealm");
    }

    /**      授权部分如下：         **/

    /**
     * doGetAuthorizationInfo 授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获取用角色
        String username = (String) principals.getPrimaryPrincipal();
        // 通过用户名从数据库或者缓存中获取到角色信息
        Set<String> roles = getRolesByUserName(username);
        // 通过用户名从数据库或者缓存中获取到权限信息
        Set<String> permission = getpermissionByUserName(username);
        // 返回对象
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 设置角色
        authorizationInfo.setRoles(roles);
        // 设置权限
        authorizationInfo.setStringPermissions(permission);
        return authorizationInfo;
    }

    /**
     * 获取权限信息
     * 模拟数据库
     *
     * @param username
     * @return
     */
    private Set<String> getpermissionByUserName(String username) {
        Set<String> sets = new HashSet<>();
        sets.add("user:select");
        sets.add("admin:delete");
        return sets;
    }

    /**
     * 获取角色信息
     * 模拟数据库
     *
     * @param username
     * @return
     */
    private Set<String> getRolesByUserName(String username) {
        Set<String> sets = new HashSet<>();
        sets.add("admin");
        sets.add("user");
        return sets;
    }

    /**      认证部分如下：         **/

    /**
     * doGetAuthenticationInfo 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 1.从主体传过来的认证信息中获取用户名
        // 使用shiro时，如果正常登陆（执行subject.login(token)成功）就能在全局通过SecurityUtils.getSubject().getPrincipal()获取用户信息
        String username = (String) token.getPrincipal();
        // 2.通过用户名到数据库中获取凭证
        String password = getPasswordUserName(username);
        if (password == null) {
            return null;
        }
        // 4.
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, "customRealm");
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("admin"));
        return authenticationInfo;
    }

    /**
     * 模拟数据库
     * 3.通过用记名称在数据库中获取到密码凭证
     *
     * @param username
     * @return
     */
    private String getPasswordUserName(String username) {
        // 读取数据库凭证
        return userMap.get(username);
    }

    public static void main(String[] args) {

        // 加盐一般使用随机数
        Md5Hash md5Hash = new Md5Hash("1234567","admin");
        System.out.println(md5Hash.toString());

    }
}
