package test01;

public class LiSi implements ILiSi{
    //李斯作为观察者,一旦韩非子活动自己也要采取行动
    public void update(String context){
        System.out.println("李斯:韩非子开始活动了,向老板汇报……");
        this.reportToQinShiHuang(context);
        System.out.println("李斯:汇报完毕……");
    }

    //向秦始皇汇报
    public void reportToQinShiHuang(String reportContext){
        System.out.println("李斯:报告秦老板!韩非子开始活动了-->" + reportContext);
    }
}
