package test0223.animal;
class Animal{
    String name;
    Animal(String name){
        this.name = name;
    }
    Animal(){}
    public void run(){
        System.out.println(name + "会跑");
    }
}

class Bird extends Animal{
    String name;
    Bird(String name){
        this.name = name;
    }
    public void fly(){
        System.out.println(name + "会飞");
    }
}
public class Test {
    public static void main(String[] args){
        Animal animal1 = new Animal("小花");
        Animal animal2 = new Bird("小鸟");
        animal1.run();
        animal2.run();
    }
}
