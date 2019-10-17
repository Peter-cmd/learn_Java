package com.test;

public class Main {
    public static void main(String[] args){
        DoubleLinkedList list = new DoubleLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.display();
        list.addIndex(-2,2);
        list.addIndex(0,2);
        list.addIndex(4,2);
        list.addIndex(7,2);
        list.addIndex(8,2);
        list.display();
        boolean ret1 = list.contains(-2);
        boolean ret2 = list.contains(5);
        boolean ret3 = list.contains(8);
        boolean ret4 = list.contains(100);
        System.out.println();
        System.out.println(ret1);
        System.out.println(ret2);
        System.out.println(ret3);
        System.out.println(ret4);
        list.remove(2);
        list.remove(-1);
        list.remove(100);
        list.remove(4);
        list.display();
        list.removeAll(2);
        list.removeAll(100);
        list.removeAll(-2);
        list.removeAll(8);
        list.display();


    }
}
