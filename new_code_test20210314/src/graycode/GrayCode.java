package graycode;

import java.util.Arrays;
import java.util.Scanner;

public class GrayCode {
    public static String[] getGray(int n) {
        // write code here
        if (n == 0) {
            return null;
        }


        String[] subResult = getGray(n - 1);
        if (n == 1) {
            return new String[]{"0", "1"};
        }
        int length = subResult.length;
        String[] result = new String[2 * length];
        for (int i = 0; i < length; i++) {
            result[i] = "0" + subResult[i];
        }

        for (int i = length - 1; i >= 0; i--) {
            result[2 * length - i - 1] = "1" + subResult[i];
        }
        return result;

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int n = in.nextInt();
            String[] result = getGray(n);
            System.out.println(Arrays.toString(result));
        }
    }
}