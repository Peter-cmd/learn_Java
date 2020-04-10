package dao.factory;

import dao.log.Log;

//抽象日志工厂类
 public abstract class LogFactory {
    //创建日志文件并返回
     public abstract Log createLog();
}
