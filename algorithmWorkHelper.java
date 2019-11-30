package SchedulingAlgorithm;

import process.MyProcess;

import java.util.ArrayList;
import java.util.Queue;

public class algorithmWorkHelper {
    //辅助处理进程
    public void workHelper(Queue<MyProcess> queue){
        ArrayList<MyProcess> processList = new ArrayList<>();
        MyProcess.avgCycleTime = 0;
        MyProcess.avgAuthCycleTime = 0;
        int count = 0;
        float startTime = 0;
        float curTime = 0;
        float cycleTime = 0;
        float sumCycleTime = 0;
        float authCycleTime = 0;
        float sumAuthCycleTime = 0;
        while (!queue.isEmpty()){  //优先级队列不为空
            MyProcess process = queue.poll();  //队首元素出队
            while (curTime < process.getArriveTime()){  //若进程提前到达
                curTime++;  //进程处于等待状态
            }
            startTime = curTime;  //开始某条处理进程
            curTime += process.getServerTime();  //统计某条进程完成时间
            count++;  //处理完的进程数加1
            cycleTime = curTime - process.getArriveTime();  //计算某条周转时间
            authCycleTime = cycleTime / process.getServerTime();  //计算某条带权周转时间
            sumCycleTime += cycleTime;   //周转时间和
            MyProcess.avgCycleTime =  sumCycleTime / count;  //计算平均周转时间
            sumAuthCycleTime += authCycleTime;  //带权周转时间和
            MyProcess.avgAuthCycleTime = sumAuthCycleTime / count;  //计算平均带权周转时间
            process.setStartTime(startTime);  //记录某条进程开始时间
            process.setFinishTime(curTime);  //记录某条进程完成时间
            process.setCycleTime(cycleTime);  //记录某条周转时间
            process.setAuthCycleTime(authCycleTime);  //记录某条带权周转时间
            processList.add(process);  //将执行完的进程插入顺序表
        }
        System.out.println("有" + count + "条进程处理完成!");
        for (MyProcess process : processList){  //循环打印顺序表的内容
            System.out.println(process.toString());
        }
        MyProcess.display();
    }
}
