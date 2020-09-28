package jdk8;

import java.util.List;
import java.util.Arrays;
import java.util.function.Consumer;

@FunctionalInterface
interface MyInterface{
    public abstract void test();
}

public class FunctionInterfaceTest{
    public FunctionInterfaceTest(MyInterface myInterface){
        myInterface.test();
    }

    public static void main(String[] args){
        FunctionInterfaceTest test = new FunctionInterfaceTest(() -> System.out.println("你好"));
        List<Integer> list = Arrays.asList(1, 2, 4, 6);
        list.forEach(interm -> System.out.println(interm));

    }
}