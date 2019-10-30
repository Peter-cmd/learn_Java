package com.Operation;

import com.Build.Libary;

import java.util.Scanner;

//归还书籍操作类
public class ReturnOperation implements Operation {
    //归还书籍
    public void work(Libary libary){
        System.out.println("归还书籍.");
        Scanner in = new Scanner(System.in);
        System.out.println("请输入您要归还的书籍id:");
        String id = in.next();
        int size = libary.getSize();
        for (int i = 0; i < size; i++){
            if (id.equals(libary.getBook(i).getId())){
                if (libary.getBook(i).getBorrowed()){
                    System.out.println("该书籍已经归还了.");
                }else{
                    System.out.println("书籍归还成功.");
                }
            }
        }
        System.out.println("未找到该书籍.");
    }
}
