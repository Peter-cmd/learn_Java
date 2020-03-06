package demo0002;

import java.util.Scanner;

public class Test02 {
    public static int fibonacci(int n){
        if (n <= 0){
            return 0;
        }

        if (n == 1 || n == 2){
            return 1;
        }

        int[] array = new int[n + 1];

        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i <= n; i++){
            array[i] = array[i - 1] + array[i - 2];
        }

        return array[n];

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("请输入第n项斐波那契数:");
        while (in.hasNext()) {
            int n = in.nextInt();
            int result = fibonacci(n);
            System.out.println(result);
        }
    }
}
