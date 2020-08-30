package my_reflect;

import java.lang.reflect.Constructor;

public class MyReflect {
    public static void main(String[] args) throws Exception {
        // 获取 Person 字节码文件
        Class personClass = Person.class;
        // 获取 Person 类的有参数的构造器
        Constructor constructor = personClass.getConstructor(String.class, Integer.class);
        // 输出构造器信息
        System.out.println(constructor);
        // 利用构造器创建一个 Person 实例
        Object person = constructor.newInstance("小明", 12);
        // 输出 Person 的实例 person 信息
        System.out.println(person.toString());
    }
}


// Person类
class Person{

    private String name;

    private Integer id;

    public Person(){

    }

    public Person(String name, Integer id){
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}