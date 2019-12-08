package SchedulingAlgorithm;

import process.MyProcess;
import processes.MyProcesses;

import java.util.*;

public class algorithmWorkHelper {
    //辅助处理进程
    public void workHelper(int choice,MyProcesses processes){
        ArrayList<MyProcess> processList = new ArrayList<>();
        Queue<MyProcess> queue = processes.orderByArriveTime();  //将所有进程按到达时间排序
        Set<MyProcess> set = new HashSet<MyProcess>();  //存储当前时间已到达的进程
        Queue<MyProcess> queue2 = new LinkedList<MyProcess>();  //用以存储按服务时间长短或按优先级排过序的队列
        MyProcess.avgCycleTime = 0;
        MyProcess.avgAuthCycleTime = 0;
        int count = 0;
        float startTime = 0;
        float curTime = 0;
        float cycleTime = 0;
        float sumCycleTime = 0;
        float authCycleTime = 0;
        float sumAuthCycleTime = 0;
        while (!queue.isEmpty() || !set.isEmpty()) {  //优先级队列不为空
            MyProcess process = null;
            if (!queue.isEmpty() && set.isEmpty()) {  //若按到达时间排序的队列不为空,且当前无已到达的进程
                process = queue.poll();  //队首元素出队
                while (curTime < process.getArriveTime()) {  //若进程还未到达
                    curTime++;  //时间流逝直到进程到达
                }
                if (choice != 1) {  //若未选择先来先服务算法
                    set.add(process);  //将待处理进程存入已到达进程集合
                    queue2.offer(process);
                }
            }
            if (!set.isEmpty()) {  //若待处理进程集合不为空
                process = queue2.poll();  //按特定规则排好序的优先级队列队首元素出队
                set.remove(process);  //将处理的完的进程移除待处理进程集合
            }
            startTime = curTime;  //开始某条处理进程
            curTime += process.getServerTime();  //统计某条进程完成时间
            count++;  //处理完的进程数加1
            cycleTime = curTime - process.getArriveTime();  //计算某条周转时间
            authCycleTime = cycleTime / process.getServerTime();  //计算某条带权周转时间
            sumCycleTime += cycleTime;   //周转时间和
            MyProcess.avgCycleTime = sumCycleTime / count;  //计算平均周转时间
            sumAuthCycleTime += authCycleTime;  //带权周转时间和
            MyProcess.avgAuthCycleTime = sumAuthCycleTime / count;  //计算平均带权周转时间
            process.setStartTime(startTime);  //记录某条进程开始时间
            process.setFinishTime(curTime);  //记录某条进程完成时间
            process.setCycleTime(cycleTime);  //记录某条周转时间
            process.setAuthCycleTime(authCycleTime);  //记录某条带权周转时间
            processList.add(process);  //将执行完的进程插入顺序表
            // 若用户选择的不是先来先服务算法
            if (choice != 1) {
                while (!queue.isEmpty()) {  //queue已按到达先后顺序排好序
                    process = queue.peek();  //查看队首元素
                    if (curTime >= process.getArriveTime()) {
                        queue.poll();  //队首元素出队
                        set.add(process);  //将当前已到达的进程存入队列
                    } else {
                        break;  //当前时间无新进程到达
                    }
                }
                //按服务时间排序
                if (choice == 2) {
                    queue2 = processes.orderByServerTime(set);  //将已到达的进程按服务时间排好序存入queue2
                }
                //按优先级排序
                if (choice == 3) {
                    queue2 = processes.orderByPriority(set);
                }
            }
        }
        System.out.println("有" + count + "条进程处理完成!");
        for (MyProcess process : processList){  //循环打印顺序表的内容
            System.out.println(process.toString());
        }
        MyProcess.display();  //打印平均周转时间和平均带权周转时间
    }
}
