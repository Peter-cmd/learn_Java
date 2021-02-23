package com.example.unit_test.controller;

import com.example.unit_test.mapper.UserMapper;
import com.example.unit_test.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest02 {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    //@MockBean
    //private UserMapper userMapper;

    @Test
    public void testLogin() throws Throwable{
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.set("name", "李斯");
        params.set("passwd", "123");
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .params(params))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}
