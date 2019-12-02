package SchedulingAlgorithm;

import process.MyProcess;
import processes.MyProcesses;

import java.util.Queue;

public class PSA extends algorithmWorkHelper implements SchedulingAlgorithm {
    //复写接口的work(优先级调度算法)
    @Override
    public void work(MyProcesses processes) {
        Queue<MyProcess> queue = processes.orderByPriority();
        super.workHelper(queue);
    }
}
