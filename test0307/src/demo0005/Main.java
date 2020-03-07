package demo0005;

import java.util.Scanner;

/**
 * 问题描述: A,B,C三个人手里各有一些糖果,
 * 现知道 A-B, B-C, A+B, B+C这四个数值[-30,30]
 * 请计算A,B,C.
 *
 * 输入样例: 1 -2 3 4
 *
 *
 * 输出样例: 2 1 3
 *
 */



public class Main {

    public static String howManyCandies(float[] array){
        StringBuilder sb = new StringBuilder();
        float A = (array[0] + array[2]) / 2;
        float B = (array[1] + array[3]) / 2;
        float C = array[3] - A;
        if (A == (int)A && A > 0){
            sb.append(A + " ");
        }
        if (B == (int)B && B > 0){
            sb.append(B + " ");
        }
        if (C == (int)C && C > 0){
            sb.append(C);
        }

        if (sb.length() == 5){
            return sb.toString();
        }
        return "No";
    }


    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        float[] array = new float[4];
        int numOfPeople = 3;
        int i = 0;
        while(in.hasNext()){
            String nums = in.nextLine();

            String[] nums1 = nums.split(" ");

            for (String num : nums1){
                array[i++] = Float.parseFloat(num);
            }

            String result = howManyCandies(array);

            System.out.println(result);
        }
    }
}
