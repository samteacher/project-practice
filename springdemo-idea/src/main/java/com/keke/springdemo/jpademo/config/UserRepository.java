package com.keke.springdemo.jpademo.config;

import com.keke.springdemo.jpademo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yuqiufu
 * @since 2019-06-13
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * 将查询直接在相应的接口方法中声明，结构更为清晰，这是Spring data的特有实现
     *
     * @return
     * @date 2019-06-14
     */
    @Query(value = "select id,name,age,email,address from user", nativeQuery = true)
    List<User> findUserList();

}
