package demo0004;

public class Test01 {
    public static void main(String[] args){
        B b = new B();
        b.jiao();
        b.set(10);
        System.out.println(b.value + "  ");

    }

    static class A{
        protected int value;

       public A(int value){
           this.value = value;
       }

        public void setValue(int value){
            this.value = value;
        }

        public int getValue(){
            return value;
        }

        public void jiao(){
            System.out.println("B");
        }
    }


    static class B extends A{

        public B(){
            super(5);
        }

        public void set(int value){
            this.value = value;
            System.out.println(super.value);
        }
        public void jiao(){
            System.out.println("C");
        }
    }
}
