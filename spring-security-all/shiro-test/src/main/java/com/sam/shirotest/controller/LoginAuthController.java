package com.sam.shirotest.controller;

import com.sam.shirotest.commen.Response;
import com.sam.shirotest.entity.SystemUser;
import com.sam.shirotest.utils.AuthenticationUtil;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录认证授权测试
 */
@RestController
public class LoginAuthController {

    @GetMapping("/get")
    public Response getString(String content) {
        Response response = new Response();
        if (content != "" && content != null) {
            return Response.success(1, content);
        } else {
            return Response.error("末知错误");
        }
    }

    @PostMapping("/login")
    public Response testLogin(SystemUser systemUser) {
        if (systemUser != null) {
            System.out.println(systemUser);
            String username = systemUser.getUsername();
            String password = systemUser.getPassword();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            boolean flag = AuthenticationUtil.getToken(token);
            System.out.println("isAuthenticated" + flag);
            if (flag) {
                return Response.data(systemUser,1, "授权成功");
            } else {
                return Response.error(-1, "授权失败");
            }
        }
        return Response.error(-1, "授权失败");
    }


}
