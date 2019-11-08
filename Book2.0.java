package com.build;

//书籍类
public class Book {
    private String id;
    private int price;
    private String name;
    private String type;
    private String author;
    private boolean isBorrowed;

    //构造函数
    public Book(String id, int price, String name,
                String type, String author, boolean isBorrowed) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.type = type;
        this.author = author;
        this.isBorrowed = isBorrowed;
    }

    //获取书籍id
    public String getId() {
        return id;
    }

    //获取书籍价格
    public int getPrice() {
        return price;
    }

    //获取书籍名字
    public String getName() {
        return name;
    }

    //获取书籍作者名字
    public String getAuthor() {
        return author;
    }

    //获取书籍类型
    public String getType() {
        return type;
    }

    //设置书籍类型
    public void setType(String type) {
        this.type = type;
    }

    //设置书籍借阅状态
    public void setBorrowed(boolean isBorrowed){ this.isBorrowed = isBorrowed; }

    //获取书籍借阅状态
    public boolean getBorrowed(){ return isBorrowed; }

    @Override
    public String toString() {  //将书籍信息转为字符串的形式输出
        return "Book{" + "id='" + id + '\'' +  // \'为转义字符
                ",price='" + price + '\'' +
                ",name='" + name + '\'' +
                ",type='" + type + '\'' +
                ",author='" + author + '\'' +
                ",isBorrowed='" + isBorrowed + '\'' +
                "}";
    }
}
