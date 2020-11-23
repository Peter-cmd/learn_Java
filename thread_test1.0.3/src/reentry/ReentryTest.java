package reentry;

import java.util.regex.Pattern;

class Parent {


    public synchronized void doSomeThing() {
        System.out.println("I am Parent");
    }

}

class Sub extends Parent {

    public synchronized void doSomeThing() {
        super.doSomeThing();
        System.out.println("I am Sub");
    }
}

public class ReentryTest {

    public static void main(String[] args){

        new Thread(new Runnable() {
            @Override
            public void run() {
                Sub sub = new Sub();
                sub.doSomeThing();
            }
        }).start();
    }

}
