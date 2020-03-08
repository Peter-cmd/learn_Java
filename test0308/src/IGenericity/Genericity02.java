package IGenericity;

public class Genericity02<T> implements IGenericity<T>{
    @Override
    public void show(T t) {
        System.out.println(t);
    }

    public static <U> void show2(U u){
        System.out.println(u);
    }

    public static void main(String[] args){

        Genericity02 g = new Genericity02();
        Genericity02.show2(1);
        Genericity02.show2("你好");
        g.show("你好");
        g.show(1);

    }
}
