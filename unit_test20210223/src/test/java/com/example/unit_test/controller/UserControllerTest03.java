package com.example.unit_test.controller;

import com.example.unit_test.UnitTestApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UnitTestApplication.class)
@AutoConfigureMockMvc
public class UserControllerTest03 {
    @Autowired
    private MockMvc mockMvc;

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
