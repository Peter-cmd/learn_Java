package demo1127;

import java.util.Scanner;

public class Test02 {

    private static String removeAll(String pattern, String regex) {
        StringBuilder sb = new StringBuilder();
        char[] subRegex = regex.toCharArray();
        int length = subRegex.length;
        for (int i = 0; i < length; i++) {
            sb.append(subRegex[i]);
            if (i != length - 1) {
                sb.append("|");
            }
        }
        return pattern.replaceAll(sb.toString(), "");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String pattern = in.nextLine();
            String regex = in.nextLine();
            String result = removeAll(pattern, regex);
            System.out.println(result);
        }
    }
}
