package com.example.unit_test.mapper;

import com.example.unit_test.user.User;
import org.springframework.stereotype.Component;

public interface UserMapper {
    boolean login(User user);

    int insert(User user);
}
