package processes;
import process.MyProcess;

import java.util.*;

public class MyProcesses {
    private Set<MyProcess> processes = new HashSet<>();  //保存录入的进程
    private int size = 0;  //待完成进程个数
    //加入进程
    public void insertIntoTail(MyProcess process){
        processes.add(process);
        size++;
        System.out.println("进程完成录入!");
    }
    //更新进程
    public void updateProcess(MyProcess process){
        processes.add(process);
        System.out.println("进程更新完毕!");
    }
    //移除进程
    public void removeProcess(MyProcess process){
        processes.remove(process);
        size--;
        System.out.println("进程完成移除!");
    }
    //打印进程的信息
    public void disPlay(MyProcess process){
        System.out.println("---------------------");
        process.toString();
        System.out.println("---------------------");
    }
    //打印所有待完成进程信息
    public void disPlayAll(){
        for (MyProcess process: processes){
            System.out.println(process.toString());
        }
    }

    //将进程按到达时间排序
    public Queue orderByArriveTime(){
        //自定义比较器
        Comparator<MyProcess> order = new Comparator<MyProcess>() {
            @Override
            public int compare(MyProcess o1, MyProcess o2) {
                return (int)(o1.getArriveTime() - o2.getArriveTime());
            }
        };
        Queue<MyProcess> queue = new PriorityQueue<MyProcess>(11,order);
        for (MyProcess process : processes) {  //遍历processes,复制所有进程信息
            if (process != null) {
                MyProcess process1 = new MyProcess(process.getTag(),  //深拷贝,保护原有数据
                        process.getPriority(),
                        process.getArriveTime(),
                        process.getServerTime());
                queue.offer(process1);  //进复制得到的进程插入优先级队列
            }
        }
        return queue;
    }

//    //将进程按到达时间排序
//    public Queue orderByArriveTime(Queue<MyProcess> queue, Queue<MyProcess> processes){
//        //自定义比较器
//        Comparator<MyProcess> order = new Comparator<MyProcess>() {
//            @Override
//            public int compare(MyProcess o1, MyProcess o2) {
//                return (int)(o1.getArriveTime() - o2.getArriveTime());
//            }
//        };
//        queue = new PriorityQueue<MyProcess>(11,order);
//        copyQueue(queue,processes);
//        return queue;
//    }

//    //进程按服务时间长短排序
//    public Queue orderByServerTime(){
//        //自定义比较器
//        Comparator<MyProcess> order1 = new Comparator<MyProcess>() {
//            @Overrid
//            public int compare(MyProcess o1, MyProcess o2) {
//                return (int) (o1.getServerTime() - o2.getServerTime());
//            }
//        };
//        Queue<MyProcess> queue = new PriorityQueue<MyProcess>(11,order1);
//        copyQueue(queue,processes);
//        return queue;
//    }

    //进程按服务时间长短排序
    public Queue<MyProcess> orderByServerTime(Set<MyProcess> processes){
        //自定义比较器
        Comparator<MyProcess> order1 = new Comparator<MyProcess>() {
            @Override
            public int compare(MyProcess o1, MyProcess o2) {
                return (int) (o1.getServerTime() - o2.getServerTime());
            }
        };
        Queue<MyProcess> queue = new PriorityQueue<MyProcess>(11,order1);
        copyQueue(queue,processes);
        return queue;
    }

//    //进程按优先级排序
//    public Queue orderByPriority(){
//        //自定义比较器
//        Comparator<MyProcess> order2 = new Comparator<MyProcess>(){
//            @Override
//            public int compare(MyProcess o1, MyProcess o2) {
//                return (int)(o2.getPriority() - o1.getPriority());
//            }
//        };
//        Queue<MyProcess> queue = new PriorityQueue<MyProcess>(11,order2);
//        copyQueue(queue,processes);
//        return queue;
//    }

    //进程按优先级排序
    public Queue<MyProcess> orderByPriority(Set<MyProcess> processes){
        //自定义比较器
        Comparator<MyProcess> order2 = new Comparator<MyProcess>(){
            @Override
            public int compare(MyProcess o1, MyProcess o2) {
                return (int)(o2.getPriority() - o1.getPriority());
            }
        };
        Queue<MyProcess> queue = new PriorityQueue<MyProcess>(11,order2);
        copyQueue(queue,processes);
        return queue;
    }

    //拷贝集合中的元素
    public static void copyQueue(Queue<MyProcess> queue, Set<MyProcess> processes){
        for (MyProcess process : processes) {  //复制
            if (process != null) {
                MyProcess process1 = process;  //浅拷贝,便于删除数据
                queue.offer(process1);  //将复制得到的进程插入优先级队列
            }
        }
    }
}
