package dao.log;

//文件日志类
public class FileLog extends Log {

    //打印文件日志内容
    @Override
    public void writeLog() {
        System.out.println("欢迎访问文件日志!");
    }
}
