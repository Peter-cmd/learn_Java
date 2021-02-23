package com.example.unit_test.service;

import com.example.unit_test.mapper.UserMapper;
import com.example.unit_test.user.User;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public boolean login(User user) {
        System.out.println(user);
        return userMapper.login(user);
    }
}
