package demo0001;

import java.util.ArrayList;
import java.util.List;

public class Demo{


    public static void main(String[] args){
        Demo demo01 = new Demo();
        List<String> list = new ArrayList<>();
        list.add("haha");
        list.add("lala");
        System.out.println();


        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        System.out.println(demo01.getFirst1(list2));
    }


    private <T>T getFirst1(List<T> data){
        if (data == null && data.size() == 0){
            return null;
        }
        return data.get(0);
    }
}
