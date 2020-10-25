package com.jdk.main;

import com.jdk.proxy.MyBeanFactory;
import com.jdk.target.CustomerDao;

public class Client {
    public static void main(String[] args){
        CustomerDao customerDao = MyBeanFactory.getBean();
        customerDao.add();
        customerDao.update();
        customerDao.delete();
        customerDao.select();
    }
}
