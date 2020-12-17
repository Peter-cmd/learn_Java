package com.example.aop_test.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements IService {

    @Override
    public void add(int a1, int a2) {
        System.out.println("add 被调用了!");
    }


    @Override
    public void sub() {
        System.out.println("sub 被调用了!");
    }
}
