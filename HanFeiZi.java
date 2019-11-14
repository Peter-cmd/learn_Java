package test01;

public class HanFeiZi implements  IHanFeiZi{
    //韩非子是否吃饭的标志
    private boolean isHaveBreakfast = false;

    //韩非子是否娱乐的标志
    private boolean isHaveFun = false;

    //韩非子吃饭
    public void haveBreakfast(){
        System.out.println("韩非开始吃饭了……");
        this.isHaveBreakfast = true;
    }

    //韩非子娱乐
    public void haveFun(){
        System.out.println("韩非子开始娱乐了……");
        this.isHaveFun = true;
    }

    //韩非子动作状态重置
    public boolean isHaveBreakfast() {
        return isHaveBreakfast;
    }

    public void setHaveBreakfast(boolean haveBreakfast) {
        isHaveBreakfast = haveBreakfast;
    }

    public boolean isHaveFun() {
        return isHaveFun;
    }

    public void setHaveFun(boolean haveFun) {
        isHaveFun = haveFun;
    }
}
