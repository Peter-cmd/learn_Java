package t02;

public class A {
    public A(){

    }

    public A getThis(){
        return this;
    }


    public static void main(String[] args){
        A a = new A();
        A b = a.getThis();
        System.out.println(a == b);
    }
}
