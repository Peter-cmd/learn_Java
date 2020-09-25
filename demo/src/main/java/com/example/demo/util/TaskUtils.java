package com.example.demo.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskUtils {

    @Scheduled(cron = "0/3 * * * * ?")
    public void doTask(){
        System.out.println(System.currentTimeMillis());
        System.out.println("执行定时任务~");
        System.out.println(System.currentTimeMillis());
    }
}
