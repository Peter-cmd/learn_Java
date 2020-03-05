package demo0001;

import java.util.Scanner;

public class ThrowTest {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        if (i > 10) throw new Exception("somethind's wrong");
    }
}
