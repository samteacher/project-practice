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
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 将查询直接在相应的接口方法中声明，结构更为清晰，这是Spring data的特有实现
     * @param lastname
     * @return
     */
    @Query("select u from User u where u.emailAddress = ?1")
    List<User> findByLastname(String lastname);

    User findByEmailAddress(String emailAddress);

}
