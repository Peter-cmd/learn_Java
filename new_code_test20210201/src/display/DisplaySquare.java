package display;
import java.math.BigInteger;
import java.util.Scanner;

public class DisplaySquare {

    private static void displaySquare(int n, String c) {
        if (n == 0 || " ".equals(c)) {
            return;
        }

        int halfN = (int)Math.round((float)n / 2);


        for (int i = 0; i < halfN; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0) || (i == halfN - 1)) {
                    System.out.print(c);
                }else if (j == 0 || j == n - 1){
                    System.out.print(c);
                }else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        while (in.hasNext()) {
//            int n = in.nextInt();
//            String c = in.next();
//            displaySquare(n, c);
//        }
        StringBuilder temp = new StringBuilder("123");
        StringBuilder sb = new StringBuilder();
        sb.append(temp);
        System.out.println(sb.toString());
    }
}