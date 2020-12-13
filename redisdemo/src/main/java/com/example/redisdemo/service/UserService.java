package com.example.redisdemo.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Cacheable(cacheNames = "user", key = "#id")
    public String getUser(int id) {
        System.out.println("我进入了 getUser 方法~");
        return "ID: " + id;
    }


    @CachePut(cacheNames = "user", key = "#id")
    public String putUser(int id) {
        System.out.println("进入 putUser 方法~");
        return "ID: " + id;
    }

    @CacheEvict(cacheNames = "user", key = "#id")
    public void delUser(int id) {
        System.out.println("进入 delUser 方法~");
    }
}
