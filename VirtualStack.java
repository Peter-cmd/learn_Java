package demo003;

import java.util.Scanner;

public class VirtualStack {

    private static final int[] DIR = {-1, 1};
    private static int[] array;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("请输入入栈的数字:");
        while (in.hasNext()){

            int num = in.nextInt();
            array = new int[num];
            virtualStack(0, num);
            System.out.println("请输入入栈的数字:");
        }
    }

    private static void virtualStack(int i, int num) {
        if (i == num){
            display();
            return;
        }

        for (int j = 1; j <= num; j++){
            array[i] = j;
            if (judge(i)){
                virtualStack(i + 1, num);
            }
        }
    }

    private static boolean judge(int i) {
        if (i == 0){
            return true;
        }
        int min = array[0];
        for (int j = 0; j < i; j++){
            if (array[i] == array[j]){
                return false;
            }
            if (min > array[j]){
                min = array[j];
            }
        }

        if (array[i] > array[i - 1]){
            return true;
        }

        if ((array[i] < array[i - 1] && array[i - 1] - array[i] == 1)
                || (array[i] == min - 1)){
            return true;
        }

        return false;
    }


    private static void display() {
        int length = array.length;
        for (int i = 0; i < length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


}
