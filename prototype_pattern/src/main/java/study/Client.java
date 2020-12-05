package study;

public class Client {

    public static void main(String[] args){

        WeeklyLog logPrevious = new WeeklyLog();
        logPrevious.setName("张三");
        logPrevious.setDate("2020年第12周");
        logPrevious.setContent("这周很充实, 每天都有班加!");

        System.out.println("*******周报*******");
        System.out.println(logPrevious.getName());
        System.out.println(logPrevious.getDate());
        System.out.println(logPrevious.getContent());
        System.out.println("-----------------------------------");

        WeeklyLog logNow;
        logNow = (WeeklyLog)logPrevious.clone();
        logNow.setDate("2020年第13周");

        System.out.println("*******周报*******");
        System.out.println(logNow.getName());
        System.out.println(logNow.getDate());
        System.out.println(logNow.getContent());
        System.out.println("-----------------------------------");
    }
}
