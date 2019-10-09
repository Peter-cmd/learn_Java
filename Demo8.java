package com.test;

public class Demo8 {
    public boolean chkPailndrome(ListNode pHead){
        int length = lengthOfList(pHead);
        int halfOfLength = length / 2;
        //处理链表为空和只有一个节点的情况
        if (pHead == null && pHead.next == null){
            return true;
        }
        //处理一般情况
        ListNode prev = null;
        ListNode cur = pHead;
        ListNode next = cur.next;
        for (int i = 0; i < halfOfLength; i++){

        }

    }
    //求链表的长度
    public int lengthOfList(ListNode pHead){
        int length = 0;
        for (ListNode cur = pHead; cur != null; cur = cur.next){
            length++;
        }
        return length;
    }
}
