package test01;

public class Client1 {
    public static void main(String[] args) throws InterruptedException{
        //定义韩非子和李斯
        HanFeiZi hanFeiZi = new HanFeiZi();
        LiSi lisi = new LiSi();

        //间谍进行监视活动
        //观察早餐情况
        Spy watchBreakfast = new Spy(hanFeiZi, lisi, "breakfast");
        //开始启动线程
        watchBreakfast.start();

        //观察娱乐情况
        Spy watchFun = new Spy(hanFeiZi, lisi, "fun");
        //开始启动线程
        watchFun.start();

        //韩非子开始活动
        Thread.sleep(1000);
        //韩非子吃早餐
        hanFeiZi.haveBreakfast();

        //韩非子娱乐了
        Thread.sleep(1000);

        hanFeiZi.haveFun();
    }
}
