package com.user;
import com.operation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//管理员类
public class Administrator extends User {

    //构造函数
    public Administrator(String name,int age, String sex, String id){
        super(name,age,sex,id);
        operations.add(new ExitOperation());
        operations.add(new AddOperation());
        operations.add(new RemoveOperation());
        operations.add(new DisplayAllOperation());
    }

    @Override
    //菜单函数
    public int menu(){
        System.out.println("******************");
        System.out.println("******************");
        System.out.println("****1.添加书籍*****");
        System.out.println("****2.删除书籍*****");
        System.out.println("****3.打印书籍*****");
        System.out.println("****0.退出程序*****");
        System.out.println("******************");
        System.out.println("******************");
        System.out.println("__________________");
        System.out.println("请输入您的选择:");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        return choice;
    }
}