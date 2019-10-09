package com.test;

public class Demo7 {
    public ListNode deleteDuplication(ListNode pHead){
        //处理链表为空的情况
        if (pHead == null){
            return null;
        }
        //处理链表只有一个节点的情况
        if (pHead.next == null){
            return pHead;
        }
        //处理链表有两个及两个以上节点的情况s
        ListNode newHead = new ListNode(-1);
        newHead.next = pHead;
        ListNode prev = newHead;
        ListNode cur = prev.next;
        while (cur != null){
            if (cur.next != null && cur.val == cur.next.val){
                while (cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                prev.next = cur;
                cur = cur.next;
            }else {
                prev = prev.next;
                cur = cur.next;
            }
        }
        return newHead.next;
    }
}
