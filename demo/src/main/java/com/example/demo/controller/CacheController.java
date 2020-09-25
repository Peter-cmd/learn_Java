package com.example.demo.controller;

import com.example.demo.pojo.Persion;
import com.example.demo.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/cache")
@RestController
public class CacheController {

    @Autowired
    CacheService cacheService;

    /**
     * 查询方法
     * @param id
     * @return
     */
    @RequestMapping("/get")
    public Persion getPersion(int id){
        return cacheService.getPersion(id);
    }

    /**
     * 修改方法
     * @param id
     * @return
     */
    @RequestMapping("/up")
    public Persion upPersion(int id){
        return cacheService.upPersion(id);
    }

    /**
     * 删除方法
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public boolean delPersion(int id){
        cacheService.delPersion(id);
        return true;
    }

}
