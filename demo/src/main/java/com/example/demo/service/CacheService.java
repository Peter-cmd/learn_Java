package com.example.demo.service;

import com.example.demo.pojo.Persion;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;

@Component
public class CacheService {

    @Cacheable(cacheNames = "persion",key = "#id")
    public Persion getPersion(int id){
        //伪代码
        System.out.println("我进入到了 getPersion 方法~");
        Persion persion = new Persion();
        persion.setId(id);
        persion.setName("Jack");
        persion.setAge(18);
        return persion;
    }

    @CachePut(cacheNames = "persion",key = "#id")
    public Persion upPersion(int id){
        //伪代码
        System.out.println("我进入到了 upPersion 方法~");
        Persion persion = new Persion();
        persion.setId(id);
        persion.setName("Jack");
        persion.setAge(30);
        return persion;
    }

    @CacheEvict(cacheNames = "persion",key = "#id")
    public void delPersion(int id){
        System.out.println("我进入了 delPersion 方法~");
    }
}
