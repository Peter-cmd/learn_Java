package com.test;

//已知从头结点的位置到环入口节点的位置等于快慢指针相遇的位置到入口节点的位置
public class Demo11 {
    public ListNode detectNodeIntoCycle(ListNode head){
        //处理链表为空的情况
        if (head == null){
            return null;
        }
        ListNode fast = head;
        ListNode low = head;
        //先判定链表中是否有环
        while (fast !=null && fast.next != null){
            fast = fast.next.next;
            low = low.next;
            if (fast == low){
                break;
            }
        }
        //处理链表中无环的情况
        if (fast == null || fast.next == null){
            return null;
        }
        ListNode cur1 = head;
        ListNode cur2 = fast;
        //循环找到入口节点
        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}
