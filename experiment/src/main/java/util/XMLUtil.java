package util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;

public class XMLUtil {

    public static Object getBean(){
        //创建一个 SAXReader 对象
        SAXReader reader = new SAXReader();
        Object object = null;
        try {
            //读取 xml 文件,获取 Document 对象
            Document document = reader.read(new File("E:\\Idea\\workspaces\\pattern_experiment\\experiment\\src\\main\\resources\\factory.xml"));
            //获取文档的根节点
            Element rootElm = document.getRootElement();
            //获取根节点下节点名为 ClassName 的子节点
            Element memberElm = rootElm.element("ClassName");
            //获取 memberElm 节点的文字
            String test = memberElm.getText();

            //利用反射获取全限定名为 test 的二进制字节码文件的 Class 对象
            Class c = Class.forName(test);
            //将 Class 实例化
            object = c.newInstance();
            return object;  //返回 test 的实例对象
        } catch (DocumentException |
                ClassNotFoundException |
                IllegalAccessException |
                InstantiationException e ) {
             throw new RuntimeException("对象创建失败!", e);
        }
    }
}
