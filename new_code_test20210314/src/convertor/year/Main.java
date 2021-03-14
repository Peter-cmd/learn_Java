package convertor.year;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
public class Main {

    private static int[] input = new int[3];
    // 月份与该月最大天数映射表
    private static Map<Integer, Integer> monthMap = new HashMap<>();
    static {
        monthMap.put(1, 31);
        monthMap.put(2, 28);
        monthMap.put(3, 31);
        monthMap.put(4, 30);
        monthMap.put(5, 31);
        monthMap.put(6, 30);
        monthMap.put(7, 31);
        monthMap.put(8, 31);
        monthMap.put(9, 30);
        monthMap.put(10, 31);
        monthMap.put(11, 30);
        monthMap.put(12, 31);
    }
    // 判定用户输入的数据是否合法
    public static int iConverDateToDay(int year, int month, int day) {

        // 年份,月份, 天数不能为0或负数, 其中月份不能大于12
        if (year <= 0 || month <= 0 || month > 12|| day <= 0) {
            return -1;
        }
        // 根据当前年份是否是闰年, 并设置2月的天数
        if (isLeapYear(year)) {
            monthMap.put(2, 29);
        }else {
            monthMap.put(2, 28);
        }
        // 判定用户输入的天数是否超出理论当前月份的最大天数
        if (day > monthMap.get(month)) {
            return -1;
        }

        input[0] = year;
        input[1] = month;
        input[2] = day;

        return 0;

    }

    // 将用户输入转成最大天数
    public static int getOutDay() {
        int outDay = 0;
        for (int i = input[1]; i > 0; i--) {
            if (i == input[1]) {
                outDay = input[2];
                continue;
            }
            outDay += monthMap.get(i);
        }

        return outDay == 0 ? -1 : outDay;
    }

    // 判定当前年份是否是闰年
    private static boolean isLeapYear(int year) {

        // 能被4整除且不能被100整除的年份是闰年
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }
        // 能被400整除的年份是闰年
        if (year % 400 == 0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int year = in.nextInt();
            int month = in.nextInt();
            int day = in.nextInt();
            int judgeResult = iConverDateToDay(year, month, day);
            if (judgeResult != -1) {
                int result = getOutDay();
                System.out.println(result);
            }else {
                System.out.println(judgeResult);
            }
        }
    }
}
