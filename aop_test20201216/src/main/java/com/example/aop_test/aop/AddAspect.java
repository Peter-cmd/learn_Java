package com.example.aop_test.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AddAspect {

    @Pointcut("execution(public * com.example.aop_test.controller.AddController.add(..))")
    public void addAspect() {

    }

//    @Before("addAspect()")
//    public void doBeforeAdd(JoinPoint point) {
//        log.info(point.toString());
//    }
//
//
    @After("addAspect()")
    public void doAfterAdd() {
        System.out.println("验证结果!");
    }

//
    @AfterReturning("addAspect()")
    public void doAfterReturningAdd() {
        System.out.println("返回结果!");
    }
//
//
//    @AfterThrowing("addAspect()")
//    public void doAfterThrowing() {
//        System.out.println("异常通知, 结果太大!");
//    }


    @Around("addAspect()")
    public void doRound(ProceedingJoinPoint point) throws Throwable{
        System.out.println("准备数据!");
        point.proceed();
        System.out.println("返回结果!");
    }
}
