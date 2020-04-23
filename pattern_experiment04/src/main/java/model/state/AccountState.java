package model.state;

import model.account.Account;

public abstract class AccountState {
    //账户对象,保存账户信息
    protected Account acc;
    //账户余额
    protected double balance;

    //检查当前账户所处的状态
    public abstract void stateCheck();

    //存款
    public void deposit(double amount){
        this.balance += amount;
        System.out.println("当前的金额为: " + this.balance);
    }

    //取款
    public void withdraw(double amount){
        this.balance -= amount;
        System.out.println("当前的金额为: " + this.balance);
    }
}
