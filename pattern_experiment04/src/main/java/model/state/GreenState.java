package model.state;

import model.account.Account;

public class GreenState extends AccountState{
    //开户(默认状态为绿色)
    public GreenState(double balace, Account acc){
        this.balance = balance;
        this.acc = acc;
    }

    //将中账户状态置为绿色
    public GreenState(AccountState state){
        this.balance = state.balance;
        this.acc = state.acc;
    }

    //检查当前账户状态
    public void stateCheck(){
        //根据余额选择是否改变转态,并确定改变为何种状态
        if (-1000 <= balance && balance < 0){
            acc.setState(new YellowState(this));
        }else if (balance < -1000){
            acc.setState(new RedState(this));
        }
    }
}
