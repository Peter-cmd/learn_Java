package com.test;
class SuperSeqList {
    private int[] List = new int[10];
    private int size = 0;  //链表中的实际元素个数
    //输出链表方法
    public void display(){
        //将数组转为字符串的格式
        System.out.print("[");
        for (int i = 0; i < List.length; i++){
            System.out.print(List[i]);
            if (i != List.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    //延长链表长度方法
    private void realloc(){
        int[] newList = new int[List.length *2];  //创建一个新数组长度是原数组的两倍
        for (int i = 0; i < List.length; i++){  //循环遍历拷贝原数组
            newList[i] = List[i];
        }
        List = newList;  //引用List指向新数组

    }

    //插入方法
    public void insert(int pos, int data){
        //判定插入位置是否合法
        if (pos < 0 || pos >= List.length){
            return;
        }
        //延长链表长度
        if (size >= List.length){
            realloc();  //调用延长链表长度
        }
        //尾插
        if (pos == this.size){
            List[pos] = data;
            this.size++;
            return;
        }
        //中间插入
        for (int i = this.size; i > pos; i--){
            List[i] = List[i - 1];
        }
        List[pos] = data;  //将data插入List的pos位
        this.size++;
        System.out.println("插入成功!");
    }

    //判定是否包含某个元素方法
    public boolean contains(int toFind){
        return search(toFind) != -1;  //调用search方法,并判定其返回值
    }

    //查找某个元素对应下标方法
    public int search(int toFind){
        for (int i = 0; i < List.length; i++){  //遍历数组查找目标元素,返回其下标
            if (List[i] == toFind){
                return i;
            }
        }
        return -1;
    }

    //获取pos位的元素方法
    public int getPos(int pos){
        if (0 <= pos && pos < List.length){  //判定pos的范围是否合法
            return List[pos];  //返回pos位的元素
        }
        return -1;
    }

    //给pos位置额元素设为value
    public void setPos(int pos ,int value){
        insert(pos,value);  //调用insert方法
    }

    //删除第一次出现的关键字
    public void remove(int toRemove){
        int pos = search(toRemove);  //调用search方法,并保存其返回值
        if (pos < 0 || pos >= List.length){  //判定pos的范围是否合法
            return;
        }
        //尾删
        if (pos == this.size - 1){
            this.size--;
            return;
        }
        //删除中间元素
        for (int i = pos; i < List.length - 1; i++){
            List[i] = List[i + 1];
        }
        this.size--;
        System.out.println("删除成功!");
    }

    //清空顺序表
    public void clear(){
        this.size = 0;  //实际元素个数清零
        List = new int[10];  //链表数据初始化
        System.out.println("顺序表已清空!");
    }
}

public class SeqList extends SuperSeqList{
    public static void main(String[] args){
        SeqList object = new SeqList();
        object.display();  //调用打印输出方法
        object.insert(1,3);  //调用插入方法
        object.display();
        System.out.println(object.contains(3));  //调用contain是方法
        System.out.println(object.contains(4));
        System.out.println("您要找的元素是:" +object.getPos(1));  //调用getPos方法
        System.out.println("您要找的元素是:" +object.getPos(2));
        object.setPos(2,1);  //调用setPos方法
        object.display();
        object.remove(1);  //调用remove方法
        object.display();
        object.clear();  //调用clear方法
        object.display();
    }
}
