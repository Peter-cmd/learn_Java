package constructor;

import student.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstrutorTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz = Class.forName("student.Student");
//        Student student = (Student)clazz.newInstance();
//        System.out.println(student);

        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Student student1 = (Student)constructor.newInstance();
        System.out.println(student1);

        Constructor constructor1 = clazz.getConstructor(String.class, Integer.class, String.class);
        Student student2 = (Student)constructor1.newInstance("小明", 12, "男");
        System.out.println(student2);


    }

}
