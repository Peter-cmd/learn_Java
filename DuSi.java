package test03;

public class DuSi implements Observer{

    //韩非子活动,杜斯采取行动
    public void update(String context){
        System.out.println("杜斯:韩非子开始活动了……");
        this.laugh(context);
        System.out.println("杜斯:笑死了……");
    }

    //杜斯笑
    public void laugh(String context){
        System.out.println("杜斯:因为" + context + "所以我高兴呀!");
    }

}
