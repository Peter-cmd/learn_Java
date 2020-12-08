package com.example.service;

import com.example.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getUser(Integer id);

    void insert(User ser);

    void update(User user);

    void delete(Integer id);
}
