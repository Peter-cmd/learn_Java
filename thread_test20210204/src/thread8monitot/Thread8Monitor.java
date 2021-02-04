package thread8monitot;
/**
 * 题目: 判断打印的 "one" or "two" ?
 *
 * 1.两个普通同步的方法, 两个线程, 标准打印, 打印? // 先one 后two 或者 先two 后one
 * 2.新增 Thread.sleep(3000) 给 getOne(), 打印? // 先等3秒 再one 最后two; 先two 再等3秒 最后one
 * 3.新增普通方法 getThree(), 打印? // one three 同时打印, 后two;   two three 同时打印, 后one
 * 4.两个普通同步方法, 两个 Number 对象, 打印? // two one 同时打印; one two 同时打印
 * 5.修改 getOne() 为静态同步方法, 打印? // one tow 同时打印; tow one 同时打印
 * 6.修改两个方法均为静态同步方法, 一个 Number 对象, 打印? // 先one 后tow; 先tow 后one
 * 7.一个静态同步方法, 一个非静态同步方法, 两个 Number 对象, 打印? // one two 同时打印; two one 同时打印
 * 8.两个静态同步方法, 两个 Number 对象, 打印? // 先one 后two; 先two 后one
 *
 */
public class Thread8Monitor {

    public static void main(String[] args){
        Number number1 = new Number();
        Number number2 = new Number();

        new Thread(new Runnable() {
            @Override
            public void run() {
                number1.getOne();
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                number2.getTwo();
            }
        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                number1.getThree();
//            }
//        }).start();
    }


}


class Number {

    public static synchronized void getOne() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("one");
    }


    public static synchronized void getTwo() {
        System.out.println("two");
    }

//    public void getThree() {
//        System.out.println("three");
//    }
}
