package com.Operation;

import com.Build.Libary;

import java.util.Scanner;

//删除书籍操作类
public class RemoveOperation implements Operation {
    //删除书籍
    public void work(Libary libary){
        //处理libary为空的情况
        if (libary == null){
            return;
        }
        System.out.println("删除书籍!");
        System.out.println("请输入您要查询的书籍id:");
        Scanner in = new Scanner(System.in);
        int i;
        String id = in.next();
        int size = libary.getSize();
        for (i = 0; i < size; i++){
            if (id.equals(libary.getBook(i).getId())){
                break;
            }
        }

        if (i >= size){
            System.out.println("抱歉未找到您想要查找的书籍.");
        }else{
            libary.setBook(i,libary.getBook(size - 1));
            libary.setSize(size - 1);
            System.out.println("删除成功.");
        }
    }
}
