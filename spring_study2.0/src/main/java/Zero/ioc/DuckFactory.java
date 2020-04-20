package Zero.ioc;

public class DuckFactory {

    public Duck creat(){
        return new Duck("鸭子3号");
    }

    public static Duck creat2(){
        return new Duck("鸭子4号");
    }
}
