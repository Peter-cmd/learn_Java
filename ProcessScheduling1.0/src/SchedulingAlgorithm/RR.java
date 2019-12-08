package SchedulingAlgorithm;

import process.MyProcess;
import processes.MyProcesses;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RR implements SchedulingAlgorithm {
    //复写接口的work方法(时间片轮转调度算法)
    @Override
    public void work(int choice, MyProcesses processes) {
        int timeSlice = 1;
        Scanner in = new Scanner(System.in);
        System.out.println("请输入时间片大小:");
        while (in.hasNext()) {
            timeSlice = in.nextInt();
            //确保时间片为正
            if (timeSlice > 0) {
                break;
            }else{
                System.out.println("时间片不能为负,请您重新输入:");
            }
        }
        float curTime = 0;
        int count = 0;  //记录处理完的进程数
        float sumCycleTime = 0;
        float sumAuthCycleTime = 0;
        MyProcess process;
        //queue用于获取按到达时间排好序的进程队列
        Queue<MyProcess> queue = processes.orderByArriveTime();
        //queue1用于存储未处理完的进程
        Queue<MyProcess> queue1 = new LinkedList<>();
        ArrayList<MyProcess> processList = new ArrayList<MyProcess>();
        while (!queue.isEmpty() || !queue1.isEmpty()) {  //若queue和queue1都不为空
            process = queue.peek();  //查看队首元素
            if (process != null && curTime >= process.getArriveTime()) {  //若当前时刻已有进程到达
                queue.poll();  //队首元素出队
                queue1.offer(process);  //已到达的进程按到达时间入queue1
            } else {
                float cycleTime = 0;
                float authCycleTime = 0;
                float restTimeSlice = 0;
                //若queue1中有待处理的进程
                if (!queue1.isEmpty()) {
                    process = queue1.peek();  //查看队首进程
                    restTimeSlice = timeSlice - process.restOfServerTime;  //计算时间片的剩余量
                    //若时间片的剩余量的大于等于0,
                    //说明有进程处理完毕.
                    if (restTimeSlice >= 0){
                        queue1.poll();  //将处理完的进程移除
                        if (process.getServerTime() == process.restOfServerTime){
                            process.setStartTime(curTime);
                        }
                        curTime += process.restOfServerTime;
                        checkAndInsert(curTime,queue,queue1);
                        process.restOfServerTime = 0; //剩余服务时间为0,进程处理完成
                        process.setFinishTime(curTime);  //记录进程完成时间
                        cycleTime = process.finishTime - process.getArriveTime();  //计算进程周转时间
                        authCycleTime = cycleTime / process.getServerTime();  //计算进程带权周转时间
                        process.setCycleTime(cycleTime);  //记录进程周转时间
                        process.setAuthCycleTime(authCycleTime);  //记录带权周转时间
                        sumCycleTime += cycleTime;
                        sumAuthCycleTime += authCycleTime;
                        processList.add(process);  //将进程加入处理完成的进程列表
                        count++;  //处理完的进程数加1
                        MyProcess.avgCycleTime = sumCycleTime / count;
                        MyProcess.avgAuthCycleTime = sumAuthCycleTime / count;
//                    while (restTimeSlice >= 0 && !queue1.isEmpty()) {  //若剩余时间片量足够处理某条进程
//                        queue1.poll();  //队首进程出队
//                        //记录进程开始处理的时间
//                        if (process.restOfServerTime == process.getServerTime()){
//                            process.setStartTime(curTime);
//                        }
//                        curTime += process.restOfServerTime;  //处理完某条进程后的时间
//                        //查看此时是否有进程到达,若有,将进程加入待处理进程队列
//                        checkAndInsert(curTime,queue,queue1);
//                        //处理已经完成的进程
//                        process.restOfServerTime = 0;  //剩余服务时间为0,进程处理完成
//                        process.setFinishTime(curTime);  //记录进程完成时间
//                        cycleTime = process.finishTime - process.getArriveTime();  //计算进程周转时间
//                        authCycleTime = cycleTime / process.getServerTime();  //计算进程带权周转时间
//                        process.setCycleTime(cycleTime);  //记录进程周转时间
//                        process.setAuthCycleTime(authCycleTime);  //记录带权周转时间
//                        sumCycleTime += cycleTime;
//                        sumAuthCycleTime += authCycleTime;
//                        processList.add(process);  //将进程加入处理完成的进程列表
//                        count++;  //处理完的进程数加1
//                        MyProcess.avgCycleTime = sumCycleTime / count;
//                        MyProcess.avgAuthCycleTime = sumAuthCycleTime / count;
//                        //若时间片有剩余,且queue1不为空
//                        process = queue1.peek();  //查看队首进程
//                        if (process == null){  //队列为空
//                            break;
//                        }
//                        //若剩余时间片能处理完该进程,继续执行循环内容
//                        //否则跳出循环
//                        float temp = restTimeSlice - process.restOfServerTime;
//                        if (temp >= 0){  //temp大于等于0表示剩余时间片能处理完该进程
//                            restTimeSlice = temp;  //更新剩余时间片
//                        }else{
//                            break;  //跳出循环,此处应注意时间片可能有剩余
//                        }
//                    }
//                    //考虑时间片是否有剩余,经过上述处理时间不会为负,且必然不能使下一条进程处理完成
//                        //restTimeSlice不等于0,表示时间片有剩余,且queue1不能为空
//                        if (restTimeSlice != 0 && !queue1.isEmpty()){
//                        process = queue1.poll();  //开始处理队首进程
//                        if (process != null && process.getServerTime() == process.restOfServerTime){
//                            process.startTime = curTime;  //记录开始执行时间
//                        }
//                        curTime += restTimeSlice;
//                        process.restOfServerTime -= restTimeSlice;  //更新剩余服务时间
//                            //查看此时是否有进程到达,若有,将进程加入待处理进程队列
//                            checkAndInsert(curTime,queue,queue1);
//                            restTimeSlice = 0;  //剩余时间片用完
//                            queue1.offer(process);  //未处理完的进程再次入队
//                        }
                    }else{  //若时间片无剩余,队首进程未处理完,次时应先不考虑之后的进程
                        queue1.poll();  //队首进程出队
                        if (process.getServerTime() == process.restOfServerTime){
                            process.setStartTime(curTime);  //记录该进程开始处理时间
                        }
                        curTime += timeSlice;
                        process.restOfServerTime -= timeSlice;
                        //查看此时是否有进程到达,若有,将进程加入待处理进程队列
                           checkAndInsert(curTime,queue,queue1);
                           queue1.offer(process);
                    }
                }else{
                    curTime++;  //时间流逝
                }
            }
        }
        System.out.println("有" + count + "条数据处理完成");
        for (MyProcess process1 : processList){  //打印输出处理完的进程
            System.out.println(process1.toString());
        }
        MyProcess.display();  //打印平均周转时间和平均带权周转时间
    }
    //查看当前是否有进程到达,并加入待处理进程队列
    public static void checkAndInsert(float curTime, Queue queue1, Queue queue2){
        while (!queue1.isEmpty()){
            MyProcess process = (MyProcess)queue1.peek();
            if (curTime >= process.getArriveTime()) {  //若当前时刻已有进程到达
                queue1.poll();  //队首元素出队
                queue2.offer(process);  //已到达的进程按到达时间入queue1
            }else{
                break;
            }
        }
    }
}