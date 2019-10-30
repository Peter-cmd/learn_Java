package com.User;

import com.Build.Libary;
import com.Operation.Operation;

abstract public class User {
    protected Operation[] operations;  //持有当前用户操作功能的对象
    String name;
    int age;
    String sex;
    String id;

    //构造函数
    public User(String name, int age, String sex, String id) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.id = id;
    }

    //设置用户年龄
    public void setAge(){
        this.age += 1;
    }

    //菜单
    abstract public int menu();

    //执行用户选择的操作
    public void doOperation(int choice, Libary libary){
        operations[choice].work(libary);
    }

    }

