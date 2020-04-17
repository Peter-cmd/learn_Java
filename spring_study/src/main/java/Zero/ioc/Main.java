package Zero.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new
            ClassPathXmlApplicationContext("applications.xml");
        // 新增这里
        Object duck1 = context.getBean("duck1");
        System.out.println(duck1.getClass());
        System.out.println(duck1);

        Object duck2 = context.getBean("duck2");
        System.out.println(duck2.getClass());
        System.out.println(duck2);

        Object duckshop = context.getBean("duckshop");
        System.out.println(duckshop.getClass());
        System.out.println(duckshop);


    }
}
