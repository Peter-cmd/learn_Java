package com.user;

import com.operation.*;

import java.util.Scanner;

//普通用户类
public class NormalUser extends User{

    //构造函数
    public NormalUser(String name,int age,String sex,String id){
        super(name,age,sex,id);
        operations.add(new ExitOperation());
        operations.add(new QueryOperation());
        operations.add(new BorrowOperation());
        operations.add(new ReturnOperation());
    }

    //菜单函数
    @Override
    public int menu(){
        System.out.println("****************");
        System.out.println("****************");
        System.out.println("****1.查询书籍****");
        System.out.println("****2.借阅书籍****");
        System.out.println("****3.归还书籍****");
        System.out.println("****0.退出程序****");
        System.out.println("*****************");
        System.out.println("*****************");
        System.out.println("__________________");
        System.out.println("请输入您的选择:");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        return choice;
    }

}
