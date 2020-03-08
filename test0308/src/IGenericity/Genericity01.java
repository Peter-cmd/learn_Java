package IGenericity;

public class Genericity01 implements IGenericity<String> {

    @Override
    public void show(String s) {
        System.out.println(s);
    }

    public static void main(String[] args){
        Genericity01 g = new Genericity01();
        g.show("你好");
    }
}
