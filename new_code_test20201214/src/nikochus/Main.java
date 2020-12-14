package nikochus;

import java.util.Scanner;


public class Main {

    private static String GetSequeOddNum(int m) {
        if (m < 0 || m == 0) {
            return null;
        }

        if (m == 1) {
            return "1";
        }

        StringBuilder sb = new StringBuilder();
        int square = m * m;
        if (m % 2 == 0) {
            int offset = m / 2;
            for (int i = offset - 1; i >= 0; i--) {
                sb.append((square - 2 * i - 1));
                sb.append("+");
            }
            for (int i = 0; i < offset; i++) {
                sb.append((square + 2 * i + 1));
                if (i != offset -  1) {
                    sb.append("+");
                }
            }
            return sb.toString();
        }else {
            int offset = m / 2;
            for (int i = offset; i >= 0; i--) {
                sb.append((square - 2 * i));
                sb.append("+");
            }
            for (int i = 1; i <= offset; i++) {
                sb.append((square + 2 * i));
                if (i != offset) {
                    sb.append("+");
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int m = in.nextInt();
            String result = GetSequeOddNum(m);
            System.out.println(result);
        }
    }
}
