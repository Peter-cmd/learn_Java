package SchedulingAlgorithm;

import process.MyProcess;
import processes.MyProcesses;
import java.util.Queue;

public class SJF extends algorithmWorkHelper implements SchedulingAlgorithm {
    //复写接口的work方法(短进程优先调度算法)
    @Override
    public void work(MyProcesses processes) {
        //依次处理进程
        Queue<MyProcess> queue = processes.orderByServerTime();
       super.workHelper(queue);
    }
}
