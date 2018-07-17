package com.example.demo.service;

import com.example.demo.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 新增一个用户
     *
     * @param name
     * @param age
     */
    @Override
    public void create(String name, Integer age) {
        jdbcTemplate.update("INSERT INTO USER(NAME ,age) VALUES (? ,?)",name,age);
    }

    /**
     * 根据name删除一个用户
     *
     * @param name
     */
    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("DELETE FROM USER WHERE NAME = ?" , name);
    }

    /**
     * 获取用户总量
     */
    @Override
    public Integer getAllUsers() {
        return  jdbcTemplate.queryForObject("SELECT COUNT(*) FROM USER ",Integer.class);
    }

    /**
     * 删除所有用户
     */
    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("DELETE FROM USER ");
    }
}