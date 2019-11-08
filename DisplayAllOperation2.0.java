package com.operation;

import com.build.Libary;

//打印所有书籍操作类
public class DisplayAllOperation implements Operation {

    //打印所有书籍
    public void work(Libary libary){
        System.out.println("打印所有书籍信息:");
        for (int i = 0; i < libary.getSize(); i++){  //遍历libary
            System.out.println(libary.getBook(i).toString());
        }
        System.out.println("一共有" + libary.getSize() + "本书.");
    }
}
