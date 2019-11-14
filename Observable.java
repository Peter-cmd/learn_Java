package test03;

public interface Observable {
    //增加一个观察者
    public void addObserver(Observer observer);

    //删除有个观察者
    public void removeObserver(Observer observer);

    //通知观察者
    public void notifyObservers(String context);
}
