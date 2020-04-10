package dao.factory;

import dao.log.FileLog;
import dao.log.Log;

//文件日志工厂类
public class FileLogFactory extends LogFactory {
    //创建一个文件日志
    @Override
    public Log createLog() {
        //返回一个文件日志实例
        return new FileLog();
    }
}
