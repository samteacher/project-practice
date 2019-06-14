package com.keke.springdemo.jpademo.controller;

import com.keke.springdemo.jpademo.config.UserRepository;
import com.keke.springdemo.jpademo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author yuqiufu
 * @since 2019-06-13
 */
@RestController
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    User userBean;

    /**
     * 使用@Query注解查询所有
     *
     * @return
     * @date 2019-06-14
     */
    @GetMapping("/findList")
    public List<User> findUserList() {
        return userRepository.findUserList();
    }

    /**
     * 查询所有方法
     *
     * @return
     */
    @RequestMapping(value = "list")
    public List<User> studentList() {
        logger.info("userList");
        return userRepository.findAll();
    }

    /**
     * 新增方法
     *
     * @param user
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "addUser")
    public User addEmp(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return null;
        }
        user.setName(user.getName());
        user.setAge(user.getAge());
        user.setEmail(user.getEmail());
        user.setAddress(user.getAddress());
        return userRepository.save(user);
    }

    /**
     * 删除方法
     *
     * @param id
     */
    @RequestMapping(value = "delete")
    public void delGirl(int id) {
        userRepository.delete(userRepository.getOne(id));
    }

    /**
     * 修改方法
     *
     * @param id
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "update")
    public User updateEmployee(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("salary") Integer age) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        return userRepository.save(user);
    }

    @GetMapping("/value")
    public String findValue() {
        return userBean.getUsername() + "==============" + userBean.getUrl();
    }

}
