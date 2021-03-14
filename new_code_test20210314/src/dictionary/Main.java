package dictionary;

import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;
public class Main {

    private static void dictionarySort(int n) {
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }

        int mark1 = n - 1;
        int mark2 = n - 1;
        display(array);
        while (mark1 != 0 || mark2 != 0) {

            for (int i = n - 1; i > 0; i--) {
                if (array[i - 1] < array[i]) {
                    mark1 = i - 1;
                    break;
                }

                if (i == 1) {
                    mark1 = 0;
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                if (array[i] > array[mark1]) {
                    mark2 = i;
                    break;
                }

                if (i == 0) {
                    mark2 = 0;
                }
            }

            if (mark1 != 0 || mark2 != 0) {
                int temp = array[mark1];
                array[mark1] = array[mark2];
                array[mark2] = temp;

                Arrays.sort(array, mark1 + 1, n);
                display(array);
            }
        }

    }

    private static void display(int[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            System.out.print(array[i]);
            if (i != length - 1) {
                System.out.print(" ");
            }else {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            dictionarySort(n);
        }
    }
}