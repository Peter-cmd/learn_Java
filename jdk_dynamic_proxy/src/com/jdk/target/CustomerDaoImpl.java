package com.jdk.target;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public int add(){
        System.out.println("添加用户成功!");
        return 1;
    }

    @Override
    public int update(){
        System.out.println("更新用户成功!");
        return 1;
    }

    @Override
    public int delete(){
        System.out.println("删除用户成功!");
        return 1;
    }

    @Override
    public int select(){
        System.out.println("查询用户成功!");
        return 1;
    }
}
