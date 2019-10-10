package com.test;

public class Demo9 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        int lengthA = lengthOfList(headA);
        int lengthB = lengthOfList(headB);
        ListNode curA = headA;
        ListNode curB = headB;
        //处理两个链表不一样长的情况
        if (lengthA < lengthB){
            for (int i = 0; i < lengthB - lengthA; i++){
                curB = curB.next;
            }
        }else {
            for (int i = 0; i < lengthA - lengthB; i++){
                curA = curA.next;
            }
        }
        //处理一般情况
        while (curA != null){
            if (curA == curB){
                return curA;
            }else {
                curA = curA.next;
                curB = curB.next;
            }
        }
        return null;
    }
    public int lengthOfList(ListNode head){
        int size = 0;
        for (ListNode cur = head; cur != null; cur = cur.next){
            size++;
        }
        return size;
    }
}
