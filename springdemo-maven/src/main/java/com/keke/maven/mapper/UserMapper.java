/**
 * tzdesk系统平台
 * tz_springmvc
 * com.tz.dao
 * UserDao.java
 * 创建人:xuchengfei
 * 时间：2015年10月8日-下午11:45:50
 * 2015潭州教育公司-版权所有
 */
package com.keke.maven.mapper;

import com.keke.maven.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author yuqiufu
 * @since 2019-06-11
 */
@Repository
public class UserMapper {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public boolean saveUser(User user) {
        String sql = "INSERT INTO tz_user(username,password,age,address,email)VALUES(?,?,?,?,?)";
        //保存，修改，删除都是update
        int count = jdbcTemplate.update(sql, user.getUsername(), user.getPassword(),
                user.getAge(), user.getAddress(), user.getEmail());
        return count > 0 ? true : false;
    }

    /**
     * 查询用户信息
     * @return
     */
    public List<User> findUser() {
        String sql = "SELECT id,username,address,`password`,email,create_time FROM tz_user";
        final List<User> users = new ArrayList<User>();
        jdbcTemplate.query(sql, new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int index) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setCreateTime(new Date(rs.getTimestamp("create_time").getTime()));
                users.add(user);
                return user;
            }
        });
        return users;
    }

}
