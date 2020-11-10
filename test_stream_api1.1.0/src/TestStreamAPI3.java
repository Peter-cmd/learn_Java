import java.util.*;
import java.util.stream.Collectors;

public class TestStreamAPI3 {
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 12, Employee.Status.BUSY),
            new Employee("李斯", 13, Employee.Status.FREE),
            new Employee("王五", 14, Employee.Status.BUSY),
            new Employee("赵六", 14, Employee.Status.VOCATION),
            new Employee("赵六", 13, Employee.Status.FREE),
            new Employee("赵六", 15, Employee.Status.VOCATION)
    );

    /**
     *  查找与匹配
     *  allMath--检查是否匹配所有元素
     *  anyMath--检查是否至少匹配一个元素
     *  noneMath--检查是否没有匹配所有元素
     *  findFirst--返回第一个元素
     *  count--返回流中元素的总个数
     *  max--返回流中最大值
     *  min--返回流中最小值
     */

    public void test1() {
        boolean b1 = employees.stream()
                .allMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b1);

        boolean b2 = employees.stream()
                .anyMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b2);

        boolean b3 = employees.stream()
                .noneMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b3);

        Optional<Employee> op = employees.stream()
                                         .sorted((e1, e2) -> Integer.compare(e2.getAge(), e1.getAge()))
                                         .findFirst();
        System.out.println(op.get());

        Optional<Employee> op2 = employees.stream()
                                          .filter((e) -> e.getStatus().equals(Employee.Status.BUSY))
                                          .findAny();
        System.out.println(op2.get());


    }

    public void test2() {
        Long count = employees.stream()
                              .count();
        System.out.println(count);

        Optional<Employee> op1 = employees.stream()
                                          .max((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
        System.out.println(op1.get());

        Optional<Integer> op2 = employees.stream()
                                          .map(Employee::getAge)
                                          .min(Integer::compare);
        System.out.println(op2.get());

    }

    /**
     *  归约
     *  reduce(T indetity, BinaryOperator) / reduce(BinaryOperator) --可以将流中的元素反复结合,
     *  最终得到一个值.
     *
     */
    public void test3() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);

        Integer sum = list.stream()
                          .reduce(0, (x, y) -> x + y);
        System.out.println(sum);

        Optional<Integer> op = employees.stream()
                                        .map(Employee::getAge)
                                        .reduce(Integer::sum);
        System.out.println(op.get());
    }

    /**
     *  收集
     *  collect--将流转换为其他形式. 接收一个Collector接口的实现, 用于
     *  给定Stream中元素做汇总的方法
     *
     */

    public void test4() {
        List<String> list = employees.stream()
                                     .map(Employee::getName)
                                     .collect(Collectors.toList());
        list.forEach(System.out::println);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~");
        Set<String> set = employees.stream()
                                   .map(Employee::getName)
                                   .collect(Collectors.toSet());
        set.forEach(System.out::println);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
        HashSet<String> hs = employees.stream()
                                      .map(Employee::getName)
                                      .collect(Collectors.toCollection(HashSet::new));
        hs.forEach(System.out::println);
    }

    public void test5() {

        // 总数
        Long count = employees.stream()
                              .collect(Collectors.counting());
        System.out.println(count);

        // 平均值
        Double avg = employees.stream()
                               .collect(Collectors.averagingInt(Employee::getAge));
        System.out.println(avg);

        // 总和
        Integer sum = employees.stream()
                               .collect(Collectors.summingInt(Employee::getAge));
        System.out.println(sum);

        // 最大值
        Optional<Employee> max = employees.stream()
                                          .collect(Collectors.maxBy((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge())));
        System.out.println(max.get());

        // 最小值
        Optional<Integer> min = employees.stream()
                                         .map(Employee::getAge)
                                         .collect(Collectors.minBy(Integer::compare));
        System.out.println(min.get());
    }

    // 分组
    public void test6() {
        Map<Employee.Status, List<Employee>> map = employees.stream()
                                                            .collect(Collectors.groupingBy(Employee::getStatus));
        for (Map.Entry<Employee.Status, List<Employee>> entry : map.entrySet()) {
            System.out.print(entry.getKey() + "  ");
            for (Employee e : entry.getValue()) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TestStreamAPI3 test = new TestStreamAPI3();
        test.test1();
        System.out.println("================");
        test.test2();
        System.out.println("-----------------");
        test.test3();
        System.out.println("+++++++++++++++++");
        test.test4();
        System.out.println("#################");
        test.test5();
        System.out.println("******************");
        test.test6();
    }
}
