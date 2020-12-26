package com.example.unit_test.controller;

import com.example.unit_test.service.UserService;
import com.example.unit_test.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String login(User user){
        return userService.login(user) + " " +  user.getName() + " " +user.getPasswd();
    }
}
