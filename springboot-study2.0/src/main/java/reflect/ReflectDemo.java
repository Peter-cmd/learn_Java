package reflect;

import zero.model.Duck;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo {
    public static void main(String[] args) throws Exception {

        Class<?> clazz = Class.forName("zero.model.Duck");
        Duck duck = (Duck)clazz.newInstance();
        System.out.println(duck);


        Duck duck2 = (Duck)clazz.getConstructor(String.class, Integer.class)
                .newInstance("小黄鸭", 2);
        System.out.println(duck2);

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){
            field.setAccessible(true);
            System.out.println(field.getName() + "=" + field.get(duck2));
        }

        Method method = clazz.getDeclaredMethod("setAge", Integer.class);
        method.invoke(duck2, 5);
        System.out.println(duck2);
    }

}
