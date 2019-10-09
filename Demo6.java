package com.test;

public class Demo6 {
    public ListNode partition(ListNode pHead,int x){
        //处理链表为空的情况
        if (pHead == null){
            return null;
        }
        //处理只有一个节点的情况
        if (pHead.next == null){
            return pHead;
        }
        //处理两个及两个以上节点的情况
        ListNode smallHead = new ListNode(-1);  //傀儡节点
        ListNode smallTail = smallHead;
        ListNode bigHead = new ListNode(-1);
        ListNode bigTail = bigHead;
        ListNode cur = pHead;
        while (cur != null){
            if (cur.val < x){
                smallTail.next = new ListNode(cur.val);
                smallTail = smallTail.next;
                cur = cur.next;
            }else{
                bigTail.next = new ListNode(cur.val);
                bigTail = bigTail.next;
                cur = cur.next;
            }
        }
        smallTail.next = bigHead.next;
        smallHead = smallHead.next;
        return smallHead;
    }
}
