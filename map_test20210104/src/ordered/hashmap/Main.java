package ordered.hashmap;

import java.util.Map;
import java.util.TreeMap;
class Cat implements Comparable<Cat>{
    public String name;
    public int age;

    public Cat(String name, int age){
        this.name = name;
        this.age = age;
    }

//    @Override
//    public boolean equals(Object obj){
//        if (obj == null){
//            return false;
//        }
//
//        if (this == obj){
//            return true;
//        }
//
//        if (obj instanceof Cat){
//            Cat cat = (Cat)obj;
//            return this.age == cat.age;
//        }
//        return false;
//    }
//
//    @Override
//    public int hashCode(){
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + age;
//        return result;
//    }

    @Override
    public int compareTo(Cat o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class Main {
    public static void main(String[] args){
        TreeMap<Cat, Integer> map = new TreeMap<>();
        map.put(new Cat("小花", 12), 2);
        map.put(new Cat("小明", 11), 4);
        map.put(new Cat("小红", 14), 1);
        map.put(new Cat("小李", 13), 2);
        for (Map.Entry<Cat, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + "--" + entry.getValue());
        }
    }
}
