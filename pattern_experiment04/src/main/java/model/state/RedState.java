package model.state;

public class RedState extends AccountState {

    public RedState(AccountState state){
        this.balance = state.balance;
        this.acc = state.acc;
    }

    //复写取款方法,提示用户账户已被冻结
    @Override
    public void withdraw(double amount) {
        System.out.println("账户已被冻结!无法继续取款.");
        System.out.println("当前的金额为: " + this.balance);
    }

    public void stateCheck(){
        //根据余额选择是否改变转态,并确定改变为何种状态
        if (balance >= 0){
            acc.setState(new GreenState(this));
        }else if(-1000 <= balance && balance < 0){
            acc.setState(new YellowState(this));
        }
    }
}
