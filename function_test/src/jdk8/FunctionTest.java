package jdk8;

import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args){
        FunctionTest test = new FunctionTest();
        System.out.println(test.compute(1, value -> 2 * value));
        System.out.println(test.compute(2, value -> value * value));
        System.out.println(test.convert(3, value -> String.valueOf(value + "Hello")));
        System.out.println(test.compute1(3, value -> value * 2, value -> value * value));
        System.out.println(test.compute2(3, value -> value * 2, value -> value * value));
    }

    public int compute(int a, Function<Integer, Integer> function){
        int result = function.apply(a);
        return result;
    }

    public String convert(int a, Function<Integer, String> function){
        return function.apply(a);
    }

    public int compute1(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2){
        return function1.compose(function2).apply(a);
    }

    public int compute2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2){
        return function1.andThen(function2).apply(a);
    }
}
