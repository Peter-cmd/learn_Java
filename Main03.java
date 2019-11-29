package Main;
import process.MyProcess;
import processes.MyProcesses;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        MyProcesses processes = new MyProcesses();
        Scanner in = new Scanner(System.in);
        String tag;
        int priority;
        float enterTime, serverTime, startTime;
        System.out.println("标识符 优先级 进入时间 服务时间 开始时间");
        while(!in.hasNext("-1")){  //循环录入进程
            tag = in.next();
            priority = in.nextInt();
            enterTime = in.nextFloat();
            serverTime = in.nextFloat();
            startTime = in.nextFloat();
            MyProcess process =
                    new MyProcess(tag,priority, enterTime, serverTime,startTime);  //实例化要录入的进程
            processes.insertIntoTail(process);  //将实例化的进程加入待完成进程列表
        }
        processes.disPlayAll();  //打印所有待完成的进程
    }
}
