package com.Operation;
import com.Build.Book;
import com.Build.Libary;
import java.util.Scanner;

//添加书籍操作类
public class AddOperation implements Operation{

    //添加书籍
    public void work(Libary libary){
        //获取书籍信息
        System.out.println("请输入要添加的书籍信息:");
        Scanner in = new Scanner(System.in);
        System.out.println("请输入书籍id:");
        String id = in.next();
        System.out.println("请输入书籍价格:");
        int price = in.nextInt();
        System.out.println("请输入书籍名字:");
        String name = in.next();
        System.out.println("请输入书籍类型:");
        String type = in.next();
        System.out.println("请输入书籍作者:");
        String author = in.next();
        Book book = new Book(id,price,name,type,author,false);
        //将书籍插入libary
        int index = libary.getSize();  //获取已存书籍个数
        libary.setBook(index,book);
        libary.setSize(libary.getSize() + 1);  //已存书籍本书加1
    }
}
