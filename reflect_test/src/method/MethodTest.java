package method;

import student.Student;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Student student = new Student("小红", 14, "女");
        Class<?> clazz = Class.forName("student.Student");

        Method method = clazz.getDeclaredMethod("eat", String.class);
        method.invoke(student, "水果");

        List<int[]> nums = new ArrayList<>();
        int[] num = {1, 2, 3, 4, 5};
        int[] num1 = {3, 4, 6, 7};
        nums.add(num);
        nums.add(num1);
        int[][] temp = nums.toArray(new int[nums.size()][]);
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                System.out.println(temp[i][j]);
            }
        }
        for (int[] i : nums) {
            System.out.println(Arrays.toString(i));
        }
        }

    }

