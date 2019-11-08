package com.operation;

import com.build.Libary;

import java.util.Scanner;

//借书籍操作类
public class BorrowOperation implements Operation {

    //借书
    public void work(Libary libary){
        //处理libary为空的情况
        if (libary == null){
            return;
        }
        //获取用户要借阅的书籍id
        System.out.println("借阅书籍!");
        System.out.println("请输入您要借的书籍id:");
        Scanner in = new Scanner(System.in);
        String id = in.next();
        int size = libary.getSize();
        //查找要借阅的书籍
        for (int i = 0; i < size; i++){
            if (id.equals(libary.getBook(i).getId())){  //找到匹配id的书籍
                //处理书籍是否被借阅的情况
                if (libary.getBook(i).getBorrowed()){
                    System.out.println("该书籍已被借阅.");
                }else{
                    System.out.println("书籍借阅成功.");
                }
                return;
            }
        }
        System.out.println("抱歉未找到您要借阅的书籍.");
    }
}

