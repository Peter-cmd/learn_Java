package demo1004;
import java.util.Scanner;
public class Main{
    private static void countsOfSoftDrink(int n){
        if (n < 3){
            System.out.println(0);
        }
        int count = 0;
        for (int i = n; i != 0;){
            if (i == 2){
                count += 1;
                break;
            }
            if  (i == 1){
                break;
            }
            count += i / 3;
            i = i % 3 + i / 3;
        }
        System.out.println(count);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            countsOfSoftDrink(n);
        }
    }
}