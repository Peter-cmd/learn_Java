package demo001;

public class Test01 {
    public static void main(String[] args){
        Integer a1 = 59;
        int a2 = 59;
        Integer a3 = Integer.valueOf(59);
        Integer a4 = new Integer(59);

        System.out.println(a1 == a3);
        System.out.println(a1 == a2);
        System.out.println(a2 == a4);
        System.out.println(a2 == a3);
        System.out.println(a4 == a3);
        System.out.println(a4 == a1);


    }
}
