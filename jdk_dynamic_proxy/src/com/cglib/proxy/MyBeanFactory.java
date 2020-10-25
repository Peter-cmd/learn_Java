package com.cglib.proxy;

import com.cglib.target.CustomerDao;
import com.jdk.advice.MyAspect;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyBeanFactory {

    public static CustomerDao getBean(){
        final CustomerDao customerDao = new CustomerDao();

        final MyAspect myAspect = new MyAspect();

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(CustomerDao.class);

        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                myAspect.myBefore();
                Object object = method.invoke(customerDao, args);
                myAspect.myAfter();
                return object;
            }
        });
        return (CustomerDao) enhancer.create();
    }


}
