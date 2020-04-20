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

        Object duck3 = context.getBean("duck3");
        System.out.println(duck3.getClass());
        System.out.println(duck3);

        Object duck4 = context.getBean("duck4");
        System.out.println(duck4.getClass());
        System.out.println(duck4);

        Object duck5 = context.getBean("duck5");
        System.out.println(duck5.getClass());
        System.out.println(duck5);

        Object duck6 = context.getBean("duck6");
        System.out.println(duck6.getClass());
        System.out.println(duck6);
    }
}
