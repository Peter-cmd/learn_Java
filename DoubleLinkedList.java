package com.test;

public class DoubleLinkedList {
    DoubleLinkedNode head = null;
    public DoubleLinkedList(){
        //创建一个傀儡节点
        head = new DoubleLinkedNode(-1);
        head.prev = head;
        head.next = head;
    }

    //头插法
    public void addFirst(int data){
        DoubleLinkedNode node = new DoubleLinkedNode(data);
        DoubleLinkedNode next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    //尾插法
    public void addLast(int data){
        DoubleLinkedNode node = new DoubleLinkedNode(data);
        DoubleLinkedNode prev = head.prev;
        prev.next = node;
        node.prev = prev;
        node.next = head;
        head.prev = node;
    }

    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index, int data){
        DoubleLinkedNode node = new DoubleLinkedNode(data);
        int size = size();
        //判定index取值是否合法
        if (index < 0 || index > size){
            return false;
        }
        //头插
        if (index == 0){
            addFirst(data);
            return true;
        }
        //尾插
        if (index == size){
            addLast(data);
            return true;
        }
        //一般插入
        DoubleLinkedNode cur = toFindIndex(index);
        DoubleLinkedNode prev = cur.prev;
        prev.next = node;
        node.prev = prev;
        node.next = cur;
        cur.prev = node;
        return true;
    }

    //求链表的长度
    public int size(){
        int size = 0;
        for (DoubleLinkedNode cur = head.next; cur != head; cur  = cur.next){
            size++;
        }
        return size;
    }

    //找到index位置的节点
    public DoubleLinkedNode toFindIndex(int index){
        int  i = 0;
        DoubleLinkedNode cur = head.next;
        while (i < index){
            cur = cur.next;
            i++;
        }
        return cur;
    }

    //查找链表中是否存在关键字key
    public boolean contains(int key){
        for (DoubleLinkedNode cur = head.next; cur != head; cur = cur.next){
            if (cur.getVal() == key){
                return true;
            }
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key){
        DoubleLinkedNode cur = toFindNode(key);
        //未找到要查找的节点
        if (cur == null){
            return;
        }
        //找到要查找的节点
        DoubleLinkedNode prev = cur.prev;
        DoubleLinkedNode next = cur.next;
        prev.next = next;
        next.prev = prev;
    }

    //删除所有值为key的节点
    public void removeAll(int key){
        while (true){
            DoubleLinkedNode cur = toFindNode(key);
            //未找到关键字为key的节点
            if(cur == null){
                return;
            }
            //找到要删除的关键字为key的节点
            DoubleLinkedNode prev = cur.prev;
            DoubleLinkedNode next = cur.next;
            prev.next = next;
            next.prev = prev;
        }
    }

    //找到关键字为key的节点
    public DoubleLinkedNode toFindNode(int key){
        for (DoubleLinkedNode cur = head.next; cur != head; cur = cur.next){
            if (cur.getVal() == key){
                return cur;
            }
        }
        return null;
    }

    //输出链表
    public void display(){
        System.out.println();
        //正向输出
        System.out.print("正向:");
        System.out.print("[");
        for (DoubleLinkedNode cur = head.next; cur != head; cur = cur.next){
            if (cur.next != head){
                System.out.print(cur.getVal() + ",");

            }else{
                System.out.print(cur.getVal() + "]");
            }
        }
        System.out.println();
        //反向输出
        System.out.print("反向:");
        System.out.print("[");
        for (DoubleLinkedNode cur = head.prev; cur != head; cur = cur.prev){
            if (cur.prev != head){
                System.out.print(cur.getVal() + ",");

            }else{
                System.out.print(cur.getVal() + "]");
            }
        }
    }
}
