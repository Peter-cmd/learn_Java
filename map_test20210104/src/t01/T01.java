package t01;

import java.util.HashMap;
import java.util.Map;

class Node {
    Integer val = 0;
    Node next = null;
    Node pre = null;

    public Node(Integer val) {
        this.val = val;
    }
}
public class T01 {
    private static Node head = null;
    private static Map<Integer, Node> map = null;
    private static void buildTree() {
        head = new Node(1);
        map = new HashMap<>();
        map.put(1, head);
        Node tail = head;
        for (int i = 2; i < 12; i++) {
            tail.next = new Node(i);
            tail.next.pre = tail;
            map.put(i, tail.next);
            tail = tail.next;
        }
    }

    private static void display() {
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }
    }

    public static void main(String[] args){
        buildTree();
        Node cur = map.get(3);
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
        display();


    }
}
