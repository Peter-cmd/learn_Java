package demo001;

import java.util.Scanner;

/**
 *问题描述:北京大学对本科生的成绩施行平均学分绩点制
 * (GPA).既将学生的实际考分根据不同的学科的不同学分
 * 按一定的公式进行计算.公式如下:实际成绩 绩点 90--
 * 100 4.0 85--89 3.7 82--84 3.3 78--81 3.0
 * 75--77 2.7 72--74 2.3 68--71 2.0 64--67 1.5
 * 60--63 1.0 60以下0
 * 1. 一门课程的学分绩点=该课绩点*该课学分
 * 2. 总评绩点=所有学科绩点之和/所有课程学分之和
 * 现要求你编写程序求出某人A的总评绩点(GPA).
 *
 * 输入描述:
 *   第一行 总的课程数n(n<10);
 *   第二行 相应课程的学分(两个学分间用空格隔开);
 *   第三行 对应课程的实际得分
 *   此处输入的所有数字均为整数.
 *
 * 输入描述:
 *   输出有一行,总评绩点,精确到小数点后2位小数.
 *   (printf("%.2f",GPA);)
 *
 * 输入样例:
 *   5
 *   4 3 4 2 3
 *   91 98 72 69 56
 *
 * 输出样例:
 *   2.52
 */
public class Main {



    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = 0;
        int[] nums = null;
        int i = 0;
        int[] grade = null;
        int j = 0;
        double sumPoint = 0;
        while (in.hasNext()){
            n = Integer.parseInt(in.nextLine());
            nums = new int[n];
            grade = new int[n];
            i = j = 0;
            String str1 = in.nextLine();
            String[] numsStr = str1.split(" ");
            for (String str : numsStr){
                nums[i] = Integer.parseInt(str);
                sumPoint += nums[i];
                i++;
            }
            String str2 = in.nextLine();
            String[] gradeStr = str2.split(" ");
            for (String str : gradeStr){
                grade[j++] = Integer.parseInt(str);
            }

            double result = point(nums, grade, sumPoint);
            System.out.printf("%.2f\n", result);
        }
    }

    private static double point(int[] nums, int[] grade, double sumPoint) {
        double avgPoint = 0;
        double point = 0;
        int length = grade.length;
        for (int i = 0; i < length; i++){
            if (90 <= grade[i]){   //90--100 4.0
                point += 4.0 * nums[i];
            }else if (85 <= grade[i]){  //85--89 3.7
                point += 3.7 * nums[i];
            }else if (82 <= grade[i]){  //82--84 3.3
                point += 3.3 * nums[i];
            }else if (78 <= grade[i]){  //78--81 3.0
                point += 3.0 * nums[i];
            }else if (75 <= grade[i]){  //75--77 2.7
                point += 2.7 * nums[i];
            }else if (72 <= grade[i]){  //72--74 2.3  9.2
                point += 2.3 * nums[i];
            }else if (68 <= grade[i]){  //68--71 2.0
                point += 2.0 * nums[i];
            }else if (64 <= grade[i]){  //64--67 1.5
                point += 1.5 * nums[i];
            }else if (60 <= grade[i]){  //60--63 1.0
                point += 1.0 * nums[i];
            }else {  //60以下0
                point += 0.0;
            }
        }
        avgPoint = point / sumPoint;
        return avgPoint;
    }
}
