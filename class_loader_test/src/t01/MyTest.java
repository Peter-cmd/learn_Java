package t01;

import com.sun.jmx.snmp.tasks.ThreadService;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

class CL{
    static {
        System.out.println("你好!");
    }
}


public class MyTest {

    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统类(应用类)加载器
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        //加载当前类的 class 信息(未初始化)
        Class<?> clazz = loader.loadClass("demo001.t01.CL");
        System.out.println(clazz);

        System.out.println("================");
        //首次主动调用导致类初始化 (静态代码块被调用)
        clazz = Class.forName("demo001.t01.CL");
        System.out.println(clazz);

        System.out.println("====================");
        //可以访问同一个包下的资源
        System.out.println(MyTest.class.getResource(""));
        //可以访问以项目下的资源
        System.out.println(MyTest.class.getResource("/"));
        //可以访问同一项目下的资源
        System.out.println(MyTest.class.getClassLoader().getResource(""));
        //返回结果为null
        System.out.println(MyTest.class.getClassLoader().getResource("/"));
        System.out.println(new Object().getClass().getClassLoader());


    }




}
