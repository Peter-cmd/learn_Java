package testhttp;

import java.io.File;
import java.io.InputStream;

public class Test {
    public static void main(String[] args){
        //不推荐 new File 的做法
        // File f = new File("../../webapp/login.html");

        //class.getResourceAsStream()是以具体的这个类编译出来的.class文件路径作为相对路径的标准
        //class.getResourceAsStream()不推荐使用
//        InputStream is3 =
//                Test.class.getResourceAsStream("../login.html");
//        System.out.println(is3);
        //推荐使用ClassLoader.getResouceAsStream()作为资源文件输入流读取操作
        //ClassLoader以编译输出文件夹根目录作为相对的标准位置
        InputStream is =
                Test.class.getClassLoader().getResourceAsStream("login.html");
        System.out.println(is);
        InputStream is2 =
                Test.class.getClassLoader().getResourceAsStream("login2.html");
        System.out.println(is2);


    }
}