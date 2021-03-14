package remove.Kth;

import java.util.Scanner;
class Node {
    public Integer val;
    public Node next;

    public Node(Integer val) {
        this.val = val;
    }
}
public class Main {

    private static Node findKthToTail(Node head, int k) {
        if (head == null) {
            return null;
        }

        if (k < 1) return head;

        Node pre = head;
        Node cur = head;
        int i = 0;
        for (i = 0; i < k && cur.next != null; i++) {
            cur = cur.next;
        }

        if (i == k - 1) {
            return head.next;
        }

        while (cur.next != null) {
            pre = pre.next;
            cur = cur.next;
        }

        if (i == k) {
            pre.next = pre.next.next;

        }



        return head;
    }

    private static void travels(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.val + " " );
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Node head = null;
        Node tail = null;
        while (in.hasNext()) {
            Integer l = in.nextInt();
            Integer k = in.nextInt();
            for (int i = 0; i < l; i++) {
                int n = in.nextInt();
                Node node = new Node(n);
                if (head  == null) {
                    head = node;
                    tail = node;
                }else {
                    tail.next = node;
                    tail = tail.next;
                }
            }
            head = findKthToTail(head, k);
            travels(head);
            head = null;
        }
    }
}
