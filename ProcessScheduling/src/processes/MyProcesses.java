package processes;
import process.MyProcess;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class MyProcesses {
    private HashMap<String, MyProcess> processes = new HashMap<>();  //保存录入的进程
    private int size = 0;  //待完成进程个数
    //加入进程
    public void insertIntoTail(MyProcess process){
        processes.put(process.getTag(),process);
        size++;
        System.out.println("进程完成录入!");
    }
    //更新进程
    public void updateProcess(MyProcess process){
        processes.put(process.getTag(),process);
        System.out.println("进程更新完毕!");
    }
    //移除进程
    public void removeProcess(MyProcess process){
        processes.remove(process.getTag());
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
        for (MyProcess process: processes.values()){
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
        copyQueue(queue,processes);
        return queue;
    }
    //进程按服务时间长短排序
    public Queue orderByServerTime(){
        //自定义比较器
        Comparator<MyProcess> order1 = new Comparator<MyProcess>() {
            @Override
            public int compare(MyProcess o1, MyProcess o2) {
                return (int)(o1.getServerTime() - o2.getServerTime());
            }
        };
        Queue<MyProcess> queue = new PriorityQueue<MyProcess>(11,order1);
        copyQueue(queue,processes);
        return queue;
    }
    //进程按优先级排序
    public Queue orderByPriority(){
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
    public static void copyQueue(Queue queue, HashMap processes){
        for (Object process : processes.values()){
            MyProcess process1 = (MyProcess) process;  //向下转型
            //复制process1,并插入队列
            MyProcess process2 = new MyProcess(process1.getTag(),process1.getPriority(),
                    process1.getArriveTime(),process1.getServerTime(),process1.getServerTime(),
                    process1.startTime,process1.finishTime,
                    process1.cycleTime,process1.authCycleTime);
            queue.offer(process2);
        }
    }
}
