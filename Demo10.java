package com.test;
public class Demo10 {
    public boolean hasCycle(ListNode head){
        //处理链表为空的情况
        if (head == null){
            return false;
        }
        //处理一般情况
        ListNode fast = head;
        ListNode low = head;
        while (fast !=  null && fast.next != null){
            fast = fast.next.next;  //fast走两步
            low = low.next;  //low走一步
            if (fast == low){  //比较两节点的内容是否相同
                return true;
            }
        }
        return false;
    }
}
