package t01;

public class Outer {
    private int a = 1;
    private static int b = 2;

    static class Inner {
        public int getC() {

           return new Outer().getA();
        }

        public int getB() {
            new Outer().a = 12;
            return new Outer().getA();
        }
    }

    public int getA() {
        return a;
    }

    public static void main(String[] args){
        Outer outer = new Outer();
        System.out.println(outer.a);
        System.out.println(outer.getA());
//        System.out.println(outer.new Inner().getA());
//        System.out.println(outer.new Inner().getB());
        System.out.println(new Inner().getB());
    }
}
