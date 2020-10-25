package com.jdk.proxy;

import com.jdk.advice.MyAspect;
import com.jdk.target.CustomerDao;
import com.jdk.target.CustomerDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanFactory {

    public static CustomerDao getBean(){

        final CustomerDao customerDao = new CustomerDaoImpl();

        final MyAspect myAspect = new MyAspect();

        return (CustomerDao) Proxy.newProxyInstance(
                MyBeanFactory.class.getClassLoader(),
                new Class[]{CustomerDao.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        myAspect.myBefore();
                        Object object = method.invoke(customerDao, args);
                        myAspect.myAfter();
                        return object;
                    }
                }
        );
    }
}

