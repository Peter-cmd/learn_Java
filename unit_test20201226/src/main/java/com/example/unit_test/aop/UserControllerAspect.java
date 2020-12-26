package com.example.unit_test.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class UserControllerAspect {

    @Pointcut("execution(public * com.example.unit_test.controller.UserController.login(..))")
    public void loginAspect() {

    }


    @Before("loginAspect()")
    public void beforeLogin() {
        log.info("用户身份验证!");
    }

    @AfterReturning("loginAspect()")
    public void afterReturningLogin() {
        log.info("用户验证成功!");
    }

}
