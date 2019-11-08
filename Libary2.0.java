package com.build;
import java.util.ArrayList;
import java.util.List;

//图书馆类
public class Libary {
    public List<Book> libary = new ArrayList<Book>();

    //默认构造函数
    public Libary(){ }

    //获取已存书籍数量
    public int getSize() {
        return libary.size();
    }

    //获取书籍
    public Book getBook(int index){
        return libary.get(index);
    }

    //插入书籍
    public void setBook(int index, Book book){
        libary.add(index,book);
    }

    //删除书籍
    public void removeBook(int index){
        libary.remove(index);

    }
}
