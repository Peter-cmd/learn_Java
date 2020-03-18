package demo001;

public class Test {
    public static void test(){
        int a = 20, b = 30;
        boolean x;
        x = a > 50 && b > 60 || a > 50 && b < -60 || a < -50 && b > 60 || a < -50 && b < -60;
        System.out.println(x);
    }


    public static void main(String[] args){
        test();
    }
}
