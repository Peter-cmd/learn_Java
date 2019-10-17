package com.test;

public class DoubleLinkedNode {
    private int val;
    public DoubleLinkedNode prev = null;
    public DoubleLinkedNode next = null;
    public DoubleLinkedNode(int val){
        this.val = val;
    }
    public int getVal(){
        return this.val;
    }
}
