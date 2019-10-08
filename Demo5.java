package com.test;
//共有n个数,其到数第k个数等价于正数第n-k个数
public class Demo5 {
    public ListNode FindKthToTail(ListNode head,int k){
        int length = size(head);
        //处理k的取值不合理的情况
        if (k <= 0 || k > length || head == null){
            return null;
        }
        //处理k的取值合理的情况
        int toFind = length - k;
        ListNode cur = head;
        for (int i = 0 ; i < toFind; i++){
            cur = cur.next;
        }
        return cur;
    }
    //求链表长度
    public int size(ListNode head){
        int size = 0;
        for (ListNode cur = head; cur != null; cur = cur.next){
            size++;
        }
        return size;
    }
}
