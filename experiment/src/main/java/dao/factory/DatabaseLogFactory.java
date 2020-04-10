package dao.factory;

import dao.log.DatabaseLog;
import dao.log.Log;

//数据库日志工厂类
public class DatabaseLogFactory extends LogFactory {
    //创建一个数据库日志,并返回
    @Override
    public Log createLog() {
        //返回一个数据库日志实例
        return new DatabaseLog();
    }
}
