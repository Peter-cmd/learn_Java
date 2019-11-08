package com.main;

import com.build.Libary;
import com.user.Administrator;
import com.user.NormalUser;
import com.user.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Libary libary = new Libary();  //实例化图书馆
        User user = login();  //实例化用户
        while(true){
            int choice = user.menu();
            user.doOperation(choice,libary);
        }
    }

    //登录身份确定
    public static User login(){
        System.out.println("**1.普通用户**");
        System.out.println("**2.管理员****");
        System.out.println("请输入您的身份:");
        Scanner in = new Scanner(System.in);
        int role = in.nextInt();
        if  (role == 1){
            return new NormalUser("向红",12,"女","0001");
        }else{
            return new Administrator("小明",15,"男","0002");
        }
    }
}
