package com.test;
public class Demo2 {
    public ListNode reverseList(ListNode head) {
        //处理链表为空的情况
        if (head == null){
            return null;
        }
        //处理只有一个节点的情况
        if (head.next == null){
            return head;
        }
        ListNode newHead = null;  //新链表的头结点
        //处理一般情况
        ListNode next = null;
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        newHead = prev;
        return newHead;
    }
}
