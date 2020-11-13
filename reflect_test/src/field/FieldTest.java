package field;

import student.Student;

import java.lang.reflect.Field;

public class FieldTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Student student = new Student("小崔", 12, "女");
        Class<?> clazz = Class.forName("student.Student");

        Field field = clazz.getField("name");
        System.out.println(field.get(student));
        field.set(student, "小红");
        System.out.println(student);

    }
}
