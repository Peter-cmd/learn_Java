package com.operation;

import com.build.Libary;

import java.util.Scanner;

//查询书籍操作类
public class QueryOperation implements Operation {

    //查询书籍
    public void work(Libary libary){
        //处理libary为空的情况
        if (libary == null){
            return;
        }
        System.out.println("查询书籍!");
        System.out.println("请输入您要查找的书籍名:");
        Scanner in = new Scanner(System.in);
        String name = in.next();
        int size = libary.getSize();  //获取图书馆已存书籍本书
        int count = 0;
        for (int i = 0; i < size; i++){  //遍历libary
            if (name.equals(libary.getBook(i).getName())){  //匹配书籍名
                System.out.println(libary.getBook(i).toString());
                count++;
            }
        }
        if (count == 0){
            System.out.println("抱歉未找到您要的书籍");
        }else{
            System.out.println("共找到" + count + "本书.");
        }
    }
}
