package demo0001;

public class Demo01 {
    public static int x = 100;

    public static void main(String[] args){
        Demo01 demo01 = new Demo01();
        demo01.x++;
        Demo01 demo02 = new Demo01();
        demo02.x++;
        demo01 = new Demo01();
        demo01.x++;
        Demo01.x--;
        System.out.println("x=" + x);

    }
}
