package test03;

public class Client3 {
    public static void main(String[] args){
        //产生三个观察者
        LiSi liSi = new LiSi();
        WangSi wangSi = new WangSi();
        DuSi duSi = new DuSi();

        //实例化韩非子
        HanFeiZi hanFeiZi = new HanFeiZi();
        hanFeiZi.addObserver(liSi);
        hanFeiZi.addObserver(wangSi);
        hanFeiZi.addObserver(duSi);
        //韩非子迟早餐
        hanFeiZi.haveFun();
    }
}
