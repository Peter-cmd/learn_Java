package SchedulingAlgorithm;
import process.MyProcess;
import processes.MyProcesses;
import java.util.Queue;
public class FCFS extends algorithmWorkHelper implements SchedulingAlgorithm{
    //复写接口的work方法(先来先服务算法)
    @Override
    public void work(int choice, MyProcesses processes) {
        super.workHelper(choice,processes);
    }
}
