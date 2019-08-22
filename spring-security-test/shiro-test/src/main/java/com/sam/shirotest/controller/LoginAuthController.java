package com.sam.shirotest.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.sam.shirotest.utils.AuthenticationUtil;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录认证授权测试
 */
@RestController
public class LoginAuthController {

    @GetMapping("/get1")
    public String getString(){
        return "asdfasdf";
    }

    @PostMapping("/login")
    public Map<String, Boolean> testLogin(Map<String, String> map) {
        Map<String, String> resultMap = new HashMap<>();
        String username = map.get("username");
        String password = map.get("password");
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        boolean flag = AuthenticationUtil.getToken(token);
        System.out.println("isAuthenticated" + flag);

        if (flag) {
//            return resultMap.put("授权成功",flag);
        } else {
//            return resultMap.put("授权失败",flag);
        }
        return null;
    }


}
