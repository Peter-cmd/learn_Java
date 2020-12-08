package com.example.mapper;

import com.example.model.User;

import java.util.List;

public interface UserMapper {
    List<User> list();

    User get(Integer id);

    void insert(User user);

    void update(User user);

    void delete(Integer id);
}
