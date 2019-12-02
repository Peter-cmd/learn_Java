package SchedulingAlgorithm;

import processes.MyProcesses;

public class Exit implements SchedulingAlgorithm{
    //退出服务
    @Override
    public void work(MyProcesses processes) {
        System.out.println("再见");
        System.exit(1);
    }
}
