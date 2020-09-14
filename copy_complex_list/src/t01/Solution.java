package t01;


import java.util.HashMap;
import java.util.Map;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Solution {
    public RandomListNode Clone(RandomListNode pHead){
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = pHead;
        // 尾结点和新的头结点
        RandomListNode newHead = null;
        RandomListNode tail = null;
        // 若 pHead 为 null,返回 null
        if (pHead == null){
            return null;
        }
        // 若 cur.next 不为 null,遍历链表
        while (cur != null){
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        // 若 cur.next 为 null,返回 null
        cur = pHead;
        // 若 当前节点不为 null
        while (cur != null){
            // 若新的头结点为 null,将头结点指向当前节点,同时更新尾结点
            if (newHead == null){
                newHead = map.get(cur);
                tail = newHead;
            }else{  // 若新的头结点不为 null,更新尾结点为当前节点
                tail = map.get(cur);
            }
            // 更新尾结点的 next 和 random
            tail.next = map.get(cur.next);
            tail.random = map.get(cur.random);
            // 节点向后遍历
            cur = cur.next;
        }
        return newHead;
    }
}
