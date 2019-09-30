package com.test;
//测试类
public class Test {
    public static void main(String[] args){
        LinkedList list = new LinkedList();  //创建一个LinkedList对象
        list.addFirst(1);  //调用头插方法
        list.printList();  //调用输出方法
        list.addLast(2);  //调用尾插方法
        list.printList();
        list.addIndex(0,2);  //调用任意位置插入方法
        list.addIndex(3,2);
        list.printList();
        boolean ret = list.contains(3);  //调用查找包含关键字key的元素是否存在在链表中方法
        System.out.println("您的查询结果为:" +ret);
        ret = list.contains(8);
        System.out.println("您的查询结果为:" +ret);
        list.remove(8);  //调用删除第一次出现关键字key的节点
        list.printList();
        list.removeAllKey(2);  //调用删除所有值为key的节点方法
        list.printList();
        list.clear();  //调用清理链表方法
        list.printList();
    }
}
