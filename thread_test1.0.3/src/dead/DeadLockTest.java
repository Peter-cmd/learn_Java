package dead;

class A {

    public synchronized static void diplayA() {
        System.out.println("I am A");
        try {
            Thread.sleep(3000);
            B.displayB();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class B {

    public synchronized  static void displayB() {
        System.out.println("I am B");
        try {
            Thread.sleep(3000);
            A.diplayA();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

public class DeadLockTest {

    public static void main(String[] args){
        new Thread(A::diplayA, "A").start();
        new Thread(B::displayB, "B").start();
    }

}
