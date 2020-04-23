package model.context;

import model.account.Account;

public class Context {
    public static void main(String[] args) {

        //用户开户,并初始化余额
        Account account = new Account("韩非", 5);
        //用户存 100 元
        account.deposit(100);
        //用户取 200 元
        account.withdraw(200);
        //用户存 1000 元
        account.deposit(1000);
        //用户取 2000 元
        account.withdraw(2000);
        //用户取 100 元
        account.withdraw(100);

    }
}
