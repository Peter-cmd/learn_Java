package com.example.aop_test.controller;

import com.example.aop_test.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddController {

    @Autowired
    ServiceImpl serviceImpl;

    @RequestMapping("/add")
    public Integer add(int a1, int a2) {
        serviceImpl.add(a1, a2);
        return (a1 + a2);
    }

}
