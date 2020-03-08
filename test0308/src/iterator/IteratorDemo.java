package iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args){
        ArrayList<Person> array = new ArrayList<>();
        Person p1 = new Person("Tom1");
        Person p2 = new Person("Tom2");
        Person p3 = new Person("Tom3");
        Person p4 = new Person("Tom4");

        array.add(p1);
        array.add(p2);
        array.add(p3);
        array.add(p4);

        Iterator<Person> iter = array.iterator();

        for (Person pp : array){
            System.out.println(pp.getName());
        }

        System.out.println("==================1");
//        for (Person pp : array){
//            pp.setName("Wang");
//        }

        //正确的删除操作,利用迭代器的remove方法
//        while(iter.hasNext()) {
//            String name = iter.next().getName();
//            System.out.println(name);
//            if (name.equals("Tom3")) {
//                iter.remove();
//            }
//        }

        System.out.println("==================2");

        for (Person pp : array){
            System.out.println(pp.getName());
        }

        System.out.println("==================3");

        //注意这里 iter.hasNext() 为 false, 由于之前的迭代,迭代器中已经没有元素了,
        //若要重新遍历需要执行 iter = array.iterator()操作
        iter = array.iterator();
        while(iter.hasNext()) {
            String name = iter.next().getName();
            System.out.println(name);
            if (name.equals("Tom1")) {
                iter.remove();
            }
        }
        //这种方法虽然可以成功删除,但由于调用了两次iter.next(),会导致输出结果有问题
        /**
         * 输出结果为:
         * Tom2
         * Tom4
         */
//        while(iter.hasNext()) {
//            if (iter.next().equals("Tom3")) {
//                iter.remove();
//            }else{
//                System.out.println(iter.next().getName());
//            }
//        }
        System.out.println("====================4");
        for (Person pp : array){
            System.out.println(pp.getName());
        }
    }
}

class Person{
    private String name;
    public Person(String name){
        this.name = name;
    }


    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}