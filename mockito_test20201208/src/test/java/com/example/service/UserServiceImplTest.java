package com.example.service;


import com.example.mapper.UserMapper;
import com.example.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@Slf4j
class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userServiceImpl;

    @Mock
    UserMapper userMapper;

    @Test
    public void testGet() {
        User user = new User();
        user.setName("落落");
        user.setId(0);
        user.setAccount("1234");
        Mockito.when(userServiceImpl.getUser(0)).thenReturn(user);
        assertEquals(user, userServiceImpl.getUser(0));
        Mockito.verify(userMapper).get(0);
        log.info("testGet() 通过!!!!!!!!!!!!!!!!!!!!!!");
    }

}