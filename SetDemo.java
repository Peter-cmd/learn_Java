package test1128;

import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();  //实例化一个HashSet
        set.add("hello");
        set.add("java");
        set.add("and");
        set.add("C语言");
        System.out.println(set);
        System.out.println(set.contains("java"));
        System.out.println(set.contains("PHP"));
        System.out.println(set.remove("PHP"));
        System.out.println(set.remove("java"));

        Iterator<String> it = set.iterator();  //实例化一个迭代器
        while (it.hasNext()){  //若迭代器不为空
            System.out.println(it.next());  //打印迭代器内容
        }
        set.clear();  //清空set
        System.out.println(set);


    }
}
