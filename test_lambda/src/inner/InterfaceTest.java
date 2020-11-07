package inner;

import com.sun.org.apache.xpath.internal.functions.FunctionOneArg;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Consumer<T> : 消费型接口
 *    void accept(T t);
 *
 * Supplier<T> : 供给型接口
 *    T get();
 *
 * Function<T, R> : 函数型接口
 *    R apply(T t);
 *
 * Predicate<T> : 断言型接口
 *    boolean test(T t);
 *
 */


public class InterfaceTest {

    // Predicate<T> 断言型接口
    public void test4() {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("Word");
        list.add("Monkey");
        list.add("Hi");

        List<String> strList = filterStr(list, str -> str.length() > 4);

        for (String string : strList) {
            System.out.println(string);
        }
    }

    // 需求: 将满足条件的字符串放入集合
    public List<String> filterStr(List<String> list, Predicate<String> pre) {
        List<String> strList = new ArrayList<>();

        for (String str : list) {
            if (pre.test(str)) {
                strList.add(str);
            }
        }
        return strList;
    }


    // Function<T, R> 函数型接口:
    public void test3() {
        String newStr = strHandle("  \t\t略略 \t\t  ", str -> str.trim());
        System.out.println(newStr);
        String subStr = strHandle("轻轻地我走了, 正如我轻轻地来", str -> str.substring(0, 6));
        System.out.println(subStr);
    }

    // 需求: 专门处理字符串
    public String strHandle(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    // Supplier<T> 供给型接口 :
    public void test2() {
        List<Integer> list = getNumList(10, () -> (int)(Math.random() * 100));

        for (Integer i : list) {
            System.out.println(i);
        }
    }

    // 需求: 产生指定个数的整数, 放入集合
    public List<Integer> getNumList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            list.add(sup.get());
        }
        return list;
    }

    // Consumer<T> 消费型接口 :
    public void test1() {
        happy(2000, m -> System.out.println("波哥喜欢大宝剑, 每次消费" + m + "元"));
    }

    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }

    public static void main(String[] args){
        InterfaceTest test = new InterfaceTest();
        test.test1();
        test.test2();
        test.test3();
        test.test4();
    }
}
