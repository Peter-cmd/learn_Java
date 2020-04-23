package model.account;

import model.state.AccountState;
import model.state.GreenState;

public class Account {
    //账户状态
    private AccountState state;

    //账户持有者
    private String owner;


    //改变账户状态
    public void setState(AccountState state){
        this.state = state;
    }

    //开户
    public Account(String owner, double init){
        this.owner = owner;
        //账户初始状态
        this.state = new GreenState(init, this);
        System.out.println(this.owner + "开户. 初始金额为: " + init);
        System.out.println("-------------------------");
    }

    //存款
    public void deposit(double amount){
        System.out.println(this.owner + "存款 " + amount + " 元.");
        //存款操作
        this.state.deposit(amount);
        //检查状态
        this.state.stateCheck();
        //利用反射获取状态名
        System.out.println("当前的账户状态为: " + this.state.getClass().getSimpleName());
        System.out.println("-------------------------");
    }

    //取款
    public void withdraw(double amount){
        System.out.println(this.owner + "取款 " + amount + " 元.");
        //取款操作
        this.state.withdraw(amount);
        //检查状态
        this.state.stateCheck();
        System.out.println("当前的账户状态为: " + this.state.getClass().getSimpleName());
        System.out.println("-------------------------");
    }

}
