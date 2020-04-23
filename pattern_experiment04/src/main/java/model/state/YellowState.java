package model.state;


public class YellowState extends AccountState {
    //将状态转为黄色状态
    public YellowState(AccountState state){
        this.balance = state.balance;
        this.acc = state.acc;
    }

    @Override
    public void stateCheck() {
        //根据余额选择是否改变转态,并确定改变为何种状态
        if (balance >= 0){
            acc.setState(new GreenState(this));
        }else if(balance < -1000){
            acc.setState(new RedState(this));
        }
    }
}
