package com.sam.shirotest.controller;

import com.sam.shirotest.commen.Response;
import com.sam.shirotest.utils.AuthenticationUtil;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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
    public Response<Map<String, String>> testLogin(Map<String, String> mapResponse) {
        Response response = new Response();
        String username = mapResponse.get("username");
        String password = mapResponse.get("password");
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        boolean flag = AuthenticationUtil.getToken(token);
        System.out.println("isAuthenticated" + flag);
        if (flag) {
            return Response.success(1, "授权成功");
        } else {
            return Response.error(-1, "授权失败");
        }
    }


}
