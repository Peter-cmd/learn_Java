package SchedulingAlgorithm;

import processes.MyProcesses;

public class Exit implements SchedulingAlgorithm{
    //复写work接口(退出服务)
    @Override
    public void work(int choice, MyProcesses processes) {
        System.out.println("再见");
        System.exit(1);
    }
}
