package node.list.test;

// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
  }

public class Main {
    public boolean hasCycle(ListNode head) {
        // 若 head 为空,则认为无环
        if (head == null){
            return false;
        }
        // 定义慢指针,每次走 1 步
        ListNode low = head;
        // 定义快指针,每次走 2 步
        ListNode fast = head;
        // 若快指针未走到链表的末尾
        while (fast != null && fast.next != null){
            // 慢指针向后遍历
            low = low.next;
            // 快指针向后遍历
            fast = fast.next.next;
            // 若快慢指针相遇跳出循环
            if (low == fast){
                break;
            }
        }
        // 若快慢指针相遇,且快指针的 next 不为 null,则存在环
        // 判定快指针不为 null 主要是为了判定只有一个节点的情况
        if(low == fast && fast.next != null){
            return true;
        }
        return false;
    }
}