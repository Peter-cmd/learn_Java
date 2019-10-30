package com.Build;

//图书馆类
public class Libary {
    private Book[] books = new Book[10];
    private int size = 0;

    //默认构造函数
    public Libary(){ }

    //设置已存书籍数量
    public void setSize(int size) { this.size = size; }

    //获取已存书籍数量
    public int getSize() {
        return size;
    }

    //获取书籍
    public Book getBook(int index){
        return books[index];
    }

    //插入书籍
    public void setBook(int index, Book book){
        this.books[index] = book;
    }
}
