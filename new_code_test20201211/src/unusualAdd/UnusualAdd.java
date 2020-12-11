package unusualAdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UnusualAdd {
    public static int addAB(int A, int B) {
        // write code here
        if (B == 0) {
            return A;
        }
        return addAB(A ^ B, (A & B) << 1);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int A = in.nextInt();
            int B = in.nextInt();
            int result = addAB(A, B);
            System.out.println(result);
        }

    }
}