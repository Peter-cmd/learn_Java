package demo003;

/**
 问题描述: 编写代码, 以给定值x为基准将链表分割成两部分,所有小于x的结点排在大于或等于
 x的结点之前
 给定一个链表的头指针ListNode* pHead, 请返回重新排列后的链表的头指针.注意:
 分割以后保持原来的数据顺序不变.
 */
import java.util.*;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        // write code here
        if (pHead == null){
            return null;
        }

        //若链表不为空
        ListNode cur = pHead;
        ListNode lessHead = null;
        ListNode lessTail = null;
        ListNode largerHead = null;
        ListNode largerTail = null;
        while (cur != null){
            if (cur.val < x){
                ListNode node = new ListNode(cur.val);
                if (lessHead == null){
                    lessHead = node;
                    lessTail = node;
                    continue;
                }

                lessTail.next = node;
                lessTail = lessTail.next;

            }else{
                ListNode node = new ListNode(cur.val);
                if (largerHead == null){
                    largerHead = node;
                    largerTail = node;
                    continue;
                }

                largerTail.next = node;
                largerTail = largerTail.next;
            }

            cur = cur.next;
        }

        if (lessHead == null){
            return largerHead;
        }

        lessTail.next = largerHead;
        pHead = lessHead;
        return pHead;
    }
}