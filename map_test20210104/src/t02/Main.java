package t02;

import java.util.*;

class Node {
    public Integer key, value;
    public Node pre, next;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class Main {
    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    private static Map<Integer, Node> map = new HashMap<>();
    private static Node head = new Node(0, 0);
    private static Node tail = new Node(0, 0);
    public static int[] LRU (int[][] operators, int k) {
        // write code here
        ArrayList<Integer> temp = new ArrayList<>();
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        for (int[] operator : operators) {
            // 插入元素
            if (operator[0] == 1){
                // 若当前容器的大小小于k, 直接进行插入操作
                if (map.size() < k){
                    set(operator[1], operator[2]);
                }else {  // 若当前容器的大小等于k
                    // 判断当前map中是否包含当前元素
                    if (map.containsKey(operator[1])){  // 若包含
                        // 将该节点移到头结点
                        set(operator[1], operator[2]);
                    }else {  // 若不包含
                        removeLast();
                        set(operator[1], operator[2]);
                    }
                }
            }else {  // 查询元素
                temp.add(get(operator[1]));
            }
        }
        int length = temp.size();
        int[] result = new int[length];
        int j = 0;
        for (Integer i : temp) {
            result[j++] = i;

        }
        return result;
    }

    private static void set(int k, int value) {
        Node cur = null;
        if (map.containsKey(k)) {
            cur = map.get(k);
            cur.value = value;
            remove(cur);
        }else {
            cur = new Node(k, value);
        }
        moveToFirst(cur);
    }

    private static void moveToFirst(Node cur) {
        cur.next = head.next;
        head.next.pre = cur;
        head.next = cur;
        cur.pre = head;
        map.put(cur.key, cur);
    }

    private static void remove(Node cur) {
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
        map.remove(cur.key);
    }

    private static void removeLast() {
        remove(tail.pre);
    }

    private static Integer get(Integer key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node cur = map.get(key);
        remove(cur);
        moveToFirst(cur);

        return cur.value;
    }

    public static void main(String[] args){
        int[][] operators = {{2,1}};
        int k = 3;
        int[] result = LRU(operators, k);
        System.out.println(Arrays.toString(result));
    }
}