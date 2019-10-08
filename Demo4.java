package com.test;

public class Demo4 {
    public ListNode mergeTwoList(ListNode T1, ListNode T2){
        //处理链表T1为空的情况
        if (T1 == null){
            return T2;
        }
        //处理链表T2为空的情况
        if (T2 == null){
            return T1;
        }
        //处理一般情况
        ListNode head = null;
        ListNode tail = null;
        ListNode cur1 = T1;
        ListNode cur2 = T2;
        //处理新链表的头节点
        if (cur1.val < cur2.val){
            head = cur1;
            tail = cur1;
            cur1 = cur1.next;
        }else{
            head = cur2;
            tail = cur2;
            cur2 = cur2.next;
        }
        //处理新链表头结点之外的节点
        while (cur1 != null && cur2 != null){
            if (cur1.val < cur2.val){
                tail.next = cur1;
                tail = tail.next;
                cur1 = cur1.next;
            }else{
                tail.next = cur2;
                tail = tail.next;
                cur2 = cur2.next;
            }
        }
        if (cur1 == null) {
            tail.next = cur2;
        } else {
            tail.next = cur1;
        }
        return head;
    }
}
