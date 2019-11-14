package test03;

public class LiSi3 implements Observer{
    //观察到韩非子的活动,李斯有所动作
    public void update(String context){
        System.out.println("李斯:韩非子开始活动了,向老板汇报……");
        this.reportToQinShiHuang(context);
        System.out.println("李斯:汇报完毕……");
    }

    //向秦始皇汇报
    public void reportToQinShiHuang(String reportContext){
        System.out.println("李斯:报告秦老板!韩非子开始活动了-->"+ reportContext);
    }

}
