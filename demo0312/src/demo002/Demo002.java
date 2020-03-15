package demo002;

public class Demo002 {
    public static void main(String[] args){
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operater(a, b);
        System.out.println(a);
        System.out.println(b);
    }

    public static void operater(StringBuffer x, StringBuffer y){
        x.append(y);
        y = x;
    }
}
