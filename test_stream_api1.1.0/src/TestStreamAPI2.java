import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class TestStreamAPI2 {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 12),
            new Employee("李斯", 13),
            new Employee("王五", 14),
            new Employee("赵六", 14),
            new Employee("赵六", 13),
            new Employee("赵六", 15)
    );

    /**
     *  筛选与切片
     *  filter--接收Lambda, 从流中排除某些元素
     *  limit--阶段流,使其元素不超过给定数量
     *  skip(n)--跳过元素, 返回一个扔掉了前n个元素的流, 若流中不足n个,
     *  则返回一个空流.与limit互补
     *  distinct--筛选, 通过流所生成元素的hashCode()和equals()去除重复元素
     *
     */

    // 内部迭代: 迭代操作由Stream API 完成
    public void test1() {
        // 中间操作: 不会执行任何操作
        Stream<Employee> stream = employees.stream()
                .filter((e) -> {
                    System.out.println("stream 中间操作");
                    return e.getAge() > 13;
                });


        // 终止操作: 一次性执行全部内容, 即"惰性求值"
        stream.forEach(System.out::println);
    }

    // 外部迭代
    public void test2() {
        Iterator<Employee> it = employees.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public void test3() {
        employees.stream()
                .filter((e) -> {
                    System.out.println("短路!");
                    return e.getAge() > 12;
                })
                .limit(2)
                .forEach(System.out::println);
    }

    public void test4() {
        employees.stream()
                .filter((e) -> {
                    System.out.println("短路!");
                    return e.getAge() > 12;
                })
                .skip(2)
                .forEach(System.out::println);
    }

    public void test5() {
        employees.stream()
                .filter((e) -> {
                    System.out.println("短路!");
                    return e.getAge() > 12;
                })
                .distinct()
                .forEach(System.out::println);
    }

    /**
     *  映射
     *  map--接收lambda, 将元素转换成其他形式或提取信息, 接收一个函数
     *  函数作为参数, 该函数会被应用到每个元素上, 并将其映射成一个新的元
     *  素.
     *  flatMap--接收一个函数作为参数, 将流中的每个值都换成另一个流,
     *  然后把所有流连接成一个流.
     */
    public void test6() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");

        list.stream()
                .map((str) -> str.toUpperCase())
                .forEach(System.out::println);
    }

    /**
     *  排序
     *  sorted()--自然排序(Comparable)
     *  sorted(Comparator com)--定制排序(Comparator)
     */

    public void test7() {
        List<String> list = Arrays.asList("ccc", "aaa", "bbb", "eee");

        list.stream()
                .sorted()
                .forEach(System.out::println);

        employees.stream()
                .sorted((e1, e2) -> {
                    if (e1.getName().equals(e2.getName())) {
                        return e1.getAge().compareTo(e2.getAge());
                    }else {
                        return e1.getName().compareTo(e2.getName());
                    }
                }).forEach(System.out::println);
    }

    public static void main(String[] args) {
        TestStreamAPI2 test = new TestStreamAPI2();
        test.test1();
        System.out.println("===============");
        test.test2();
        System.out.println("****************");
        test.test3();
        System.out.println("----------------");
        test.test4();
        System.out.println("++++++++++++++++");
        test.test5();
        System.out.println("@@@@@@@@@@@@@@@@");
        test.test6();
        System.out.println("!!!!!!!!!!!!!!!!");
        test.test7();
    }
}
