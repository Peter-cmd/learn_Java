package com.cglib.main;

import com.cglib.proxy.MyBeanFactory;
import com.cglib.target.CustomerDao;


public class Client {
    public static void main(String[] args){
        CustomerDao customerDao = MyBeanFactory.getBean();
        customerDao.add();
        customerDao.delete();
        customerDao.select();
        customerDao.update();

    }
}
