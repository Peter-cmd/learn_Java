package demo002;

public class Demo002 {
    public static void main(String[] args){
        String a = "a";
        String b = "b";
        String c = "a" + "b";
        String d = "ab";
        String e = new String("ab");
        System.out.println(d == e);
        System.out.println(c == d);
        System.out.println(c == e);
    }
}
