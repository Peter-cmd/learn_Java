package Main;
import SchedulingAlgorithm.SchedulingAlgorithm;
import SchedulingAlgorithm.FCFS;
import SchedulingAlgorithm.SJF;
import SchedulingAlgorithm.PSA;
import process.MyProcess;
import processes.MyProcesses;
import User.User;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        MyProcesses processes = new MyProcesses();
        Scanner in = new Scanner(System.in);
        User user = new User();
        String tag;
        int priority, number;
        float arriveTime, serverTime;
        System.out.println("请输入你要录入的进程数:");
        number = in.nextInt();
        System.out.println("标识符 优先级 进入时间 服务时间");
        while(in.hasNext()){  //循环录入进程
            tag = in.next();
            priority = in.nextInt();
            arriveTime = in.nextFloat();
            serverTime = in.nextFloat();
            if (priority < 0 || arriveTime < 0 || serverTime < 0){
                System.out.println("数据不能为负,请重新输入:");
                continue;
            }
            MyProcess process =
                    new MyProcess(tag, priority, arriveTime, serverTime);  //实例化要录入的进程
            processes.insertIntoTail(process);  //将实例化的进程加入待完成进程列表
            number--;
            if (number == 0){  //达到要录入的进程数
                break;  //跳出循环
            }
        }
        processes.disPlayAll();  //打印所有待完成的进程
        while (true) {
            int choose = user.menu();
            user.doAlgorithm(choose,processes);
        }
    }
}
