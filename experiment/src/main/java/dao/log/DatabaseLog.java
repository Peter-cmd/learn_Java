package dao.log;

//数据库文件日志类
public class DatabaseLog extends Log {
    //打印数据库文件内容
    @Override
    public void writeLog() {
        System.out.println("欢迎访问数据库日志!");
    }
}
