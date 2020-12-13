package com.example.redisdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.redisdemo.service.UserService;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/get")
    public String getUser(int id) {
        return userService.getUser(id);
    }

    @RequestMapping("/put")
    public String putUser(int id) { return userService.putUser(id); }

    @RequestMapping("/del")
    public void delUser(int id) { userService.delUser(id);}
}
