package field;

public class T01 {
    public T01(){
        System.out.println("初始化");
        System.out.println(a);
    }

    public static int a = 2;

    static {
        System.out.println(a);
        a = 1;
        System.out.println(a);
    }

    public static void main(String[] args){
        System.out.println(T01.a);
    }
}