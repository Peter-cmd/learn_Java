package t02;

public class Test01 {
    private int p = 10;
    private static int a = 20;
    public static void main(String[] args){
        System.out.println(new Test01().a);
        Test01.a = 10;
        System.out.println(new Test01().a);
    }
}
