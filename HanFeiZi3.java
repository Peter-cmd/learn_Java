package test03;
import test01.IHanFeiZi;

import java.util.ArrayList;

public class HanFeiZi3 implements IHanFeiZi, Observable{
    //定义一个变长数组,存放所有的观察者
    private ArrayList<Observer> observerList = new ArrayList<Observer>();

    //增加观察者
    public void addObserver(Observer observer){
        this.observerList.add(observer);
    }

    //删除观察者
    public void removeObserver(Observer observer){
        this.observerList.remove(observer);
    }

    //通知所有观察者
    public void notifyObservers(String context){
        for (Observer observer : observerList){
            observer.update(context);
        }
    }

    //韩非子吃饭
    public void haveBreakfast(){
        System.out.println("韩非子:开始吃饭了……");
        //通知所有观察者
        this.notifyObservers("韩非子在吃饭--");
    }

    //韩非子娱乐
    public void haveFun(){
        System.out.println("韩非子:开始娱乐了……");
        //通知所有观察者
        this.notifyObservers("韩非子在娱乐--");
    }
}
