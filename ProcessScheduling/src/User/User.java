package User;
import SchedulingAlgorithm.SchedulingAlgorithm;
import SchedulingAlgorithm.FCFS;
import SchedulingAlgorithm.SJF;
import SchedulingAlgorithm.PSA;
import SchedulingAlgorithm.RR;
import SchedulingAlgorithm.Exit;
import processes.MyProcesses;
import java.util.Scanner;

public class User {
    //用户拥有所有的操作
    private SchedulingAlgorithm[] algorithms = {new Exit(),
                                                new FCFS(),
                                                new SJF(),
                                                new PSA(),
                                                new RR()};

    //菜单
    public int menu(){
         System.out.println("---------------");
         System.out.println("---------------");
         System.out.println("***0.退出服务***");
         System.out.println("**1.先来先服务**");
         System.out.println("**2.短作业优先**");
         System.out.println("**3.优先级调度**");
         System.out.println("**4.时间片轮转**");
         System.out.println("---------------");
         System.out.println("---------------");
         System.out.println("请输入你的选择:");
         Scanner in = new Scanner(System.in);
         int choose = -1;
         while (in.hasNext()) {
             choose = in.nextInt();
             if (choose >= 0 && choose <= 4){
                 break;
             }else{
                 System.out.println("请输入合法数据!");
                 System.out.println("请输入你的选择:");
             }
         }
         return choose;
    }

    //调用用户选择的算法
    public void doAlgorithm(int choose, MyProcesses processes){algorithms[choose].work(processes);}
}
