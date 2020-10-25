package com.cglib.advice;

public class Aspect {

    public void myBefore(){
        System.out.println("方法执行前!");
    }

    public void myAfter(){
        System.out.println("方法执行后!");
    }
}
