package com.example.unit_test.mapper;

import com.example.unit_test.user.User;
import org.springframework.stereotype.Component;


@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public boolean login(User user) {
        return true;
    }

    @Override
    public int insert(User user) {
        return 1;
    }
}
