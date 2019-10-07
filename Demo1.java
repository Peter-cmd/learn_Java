package com.test;
public class Demo1 {
    public ListNode removeElements(ListNode head, int val) {
        //处理链表为空的情况
        if (head == null){
            return null;
        }
        //处理val非头结点的值得情况
        ListNode prev = head;
        ListNode cur = head.next;
        while(cur != null){
            if(cur.val == val){
                prev.next = cur.next;
                cur = prev.next;
            }else{
                prev = cur;
                cur = cur.next;
            }
        }
        //处理val是头结点的值得情况
        if (head.val == val){
            head = head.next;
        }
        return head;
    }
}


