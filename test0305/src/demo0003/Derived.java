package demo0003;

class Base{

//    public Base(String str){
//        System.out.println("B");
//    }
}
public class Derived extends Base{
//    public Derived(){
//        super("B");
//    }
    public Derived(String str){

        System.out.println("D");
    }

    public static void main(String[] args){
        new Derived("C");
    }
}
