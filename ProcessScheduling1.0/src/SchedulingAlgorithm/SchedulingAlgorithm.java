package SchedulingAlgorithm;

import processes.MyProcesses;

public interface SchedulingAlgorithm {
    //算法的工作内容
    public void work(int choice, MyProcesses processes);
}
