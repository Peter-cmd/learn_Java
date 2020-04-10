package dao.client;


import dao.factory.LogFactory;
import dao.log.Log;
import util.XMLUtil;

//客户端类
public class Client {
    //主函数
    public static void main(String[] args){
        //调用 XMLUtil 的类方法创建一个 LogFactory 的子类实例
        LogFactory logFactory = (LogFactory) XMLUtil.getBean();
        //调用实例工厂的 createLog() 方法创建对应的 Log 的子类实例
        Log log = logFactory.createLog();
        //调用日志对象的打印功能,打印日志内容
        log.writeLog();
    }

}
