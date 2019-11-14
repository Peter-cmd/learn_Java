package test03;

public class WangSi implements Observer{
    //观察到韩非子活动,采取行动
    public void update(String context){
        System.out.println("王斯:韩非子开始活动了……");
        this.cry(context);
        System.out.println("王斯:哭死了……");
    }

    //王斯哭泣
    public void cry(String context){
        System.out.println("王斯:因为" + context + "所以我难过啊!");
    }
}
