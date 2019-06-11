package com.keke.maven.controller;

import com.keke.maven.entity.User;
import com.keke.maven.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author yuqiufu
 * @since 2019-06-11
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public ModelAndView user(){
        ModelAndView modelAndView = new ModelAndView();
        List<User> users = userService.findUser();
        modelAndView.addObject("users", users);
        modelAndView.setViewName("user");
        return modelAndView;
    }

    @RequestMapping("/user/save")
    public ModelAndView usersave(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setAge(Integer.parseInt(request.getParameter("age")));
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setAddress(request.getParameter("address"));
        user.setEmail(request.getParameter("email"));
        boolean flag = userService.saveUser(user);
        if(flag){
            modelAndView.setViewName("success");
        }else{
            modelAndView.setViewName("fail");
        }
        return modelAndView;
    }

}
