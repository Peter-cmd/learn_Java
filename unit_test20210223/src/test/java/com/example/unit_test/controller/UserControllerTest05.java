package com.example.unit_test.controller;

import com.example.unit_test.service.UserService;
import com.example.unit_test.user.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest05 {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    User user = new User();

    @Before
    public void setUp() throws Exception {
        //MockitoAnnotations.initMocks(this);
        user.setName("李阿斯");
        doReturn(true).when(userService).login(user);
    }

    @Test
    public void testLogin() throws Throwable{
        System.out.println(userController.login(user));
    }
}
