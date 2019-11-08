package com.user;
import com.build.Libary;
import com.operation.Operation;
import java.util.ArrayList;
import java.util.List;

abstract public class User {
    protected List<Operation> operations = new ArrayList<>();  //持有当前用户操作功能的对象
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
        operations.get(choice).work(libary);
    }

}

