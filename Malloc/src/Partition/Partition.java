package Partition;

public class Partition {
    public int startAddress;  //分区始址
    public int endAddress;  //分区终址
    public int size;  //分区大小
    public Partition prev = null;  //指向前一分区
    public Partition next = null;  //指向后一分区
    public boolean state = false;  //若 state 为 false 则分区空闲,反之分区已分配
    //构造方法
    public Partition(int start, int end) {
        this.startAddress = start;
        this.endAddress = end;
        this.size = end - start;
        this.prev = null;
        this.next = null;
    }
}
