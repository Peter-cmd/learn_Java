package com.test;

public class Demo3 {
    public ListNode middleNode (ListNode head){
        //处理链表为空的情况
        if (head == null){
            return null;
        }
        //处理只有一个元素的情况
        if (head.next == null){
            return head;
        }
        //处理链表非空的情况
        ListNode cur = head;
        int length = lengthOfList(head);
        int half_length = length / 2;
        for (int i = 0; i < half_length; i++){
            cur = cur.next;
        }
        return cur;
    }
    //求链表长度
    public int lengthOfList(ListNode head){
        int size = 0;
        for (ListNode cur = head; cur != null; cur = cur.next){
            size++;
        }
        return size;
    }
}
