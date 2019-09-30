package com.test;

//节点类
class LinkedNode{
    private int data = 0;
    public LinkedNode next = null;
    //带参构造方法
    public LinkedNode(int data){
        this.data = data;
    }
    //获得data的值方法
    public int getData(){
        return this.data;
    }
}

//链表类
public class LinkedList {
    private LinkedNode head = null;

    //头插方法
    public void addFirst(int elem){
        LinkedNode node  = new LinkedNode(elem);
        if (head == null){
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    //尾插方法
    public void addLast(int elem){
        LinkedNode node = new LinkedNode(elem);
        if (head == null){
            head = node;
            return;
        }
        LinkedNode last_node = lastNode();
        last_node.next = node;
    }

    //遍历链表找最后一个节点方法
    public LinkedNode lastNode(){
        LinkedNode cur = this.head;
        while(cur.next != null){
            cur = cur.next;
        }
        return cur;
    }

    //查找包含关键字key的元素是否存在在链表中方法
    public  boolean contains(int key){
        //遍历链表
        for (LinkedNode cur = this.head; cur != null; cur = cur.next){
            if (cur.getData() == key){
                return true;
            }
        }
        return false;
    }

    //删除第一次出现关键字key的节点
    public void remove(int key) {
        //若链表为空的情况
        if (this.head == null) {
            return;
        }
        //若关键字节点为头结点
        if (this.head.getData() == key) {
            this.head = this.head.next;
            return;
        }
        //若关键字为中间节点
        LinkedNode prev = previousNode(key);
        if (prev != null){  //放回值不为空
            LinkedNode newNode = prev.next;
            prev.next = newNode.next;
    }
    }

    //找到关键字为key的节点的前一个节点方法
    public LinkedNode previousNode(int key){
        if (this.head == null){
            return null;
        }
        for (LinkedNode prev = this.head; prev.next != null; prev = prev.next){
            if (prev.next.getData() == key){
                return prev;
            }
        }
        return null;
    }

    //删除所有值为key的节点方法
    public void removeAllKey(int key){
        LinkedNode cur = head.next;  //cur从头节点的下一节点开始
        LinkedNode prev = head;  //prev指向cur指向的前一个元素
        if (head == null){
            return;
        }
        //先考虑key为中间节点的情况
            while (cur != null){
                if (cur.getData() == key){  //若该节点是要删除的节点
                   prev.next = cur.next;
                   cur = prev.next;
                }else{  //不用删除该节点
                    prev = cur;
                    cur = cur.next;
                }
            }

        //考虑key为头结点的情况
        if (head.getData() == key){
            head = head.next;
        }
    }

    //任意位置插入方法
    public boolean addIndex(int index, int elem){
        int length = lengthOfList();  //调用求链表长度方法
        LinkedNode node = new LinkedNode(elem);
        if (index < 0 || index > length){
            return false;
        }
        //调用头插方法
        if (index == 0 || head == null){
          addFirst(elem);
          return true;
        }
        //调用尾插方法
        if (index == length){
          addLast(elem);
          return true;
        }
        //中间插入
        LinkedNode prev = toPos(index - 1);
        node.next = prev.next;
        prev.next = node;
        return true;
    }

    //找到要插入的节点位置方法
    public LinkedNode toPos(int index){
        LinkedNode cur = this.head;
        for(int i = 1; i < index; i++){
            cur = cur.next;
        }
        return cur;
    }

    //求链表长度方法
    public int lengthOfList(){
        int length = 0;
        for (LinkedNode cur = this.head; cur != null; cur = cur.next){
            length++;
        }
        return length;
    }

    //输出方法
    public void printList(){
        System.out.print("[");
        for (LinkedNode cur = this.head; cur != null; cur = cur.next){
            System.out.print(cur.getData());
            if (cur.next != null){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    //清空链表方法
    public void clear(){
        head = null;
    }
}
