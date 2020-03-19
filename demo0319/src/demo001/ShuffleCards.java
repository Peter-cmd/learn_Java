package demo001;

import java.util.Scanner;

/**
 问题描述: 模拟洗牌,左手一半,右手一半,两手依次放下一张直到两手都无牌为止

 输入描述: 第一行一个数T(T<=100), 表示数据组数. 对于每组数据, 第一行两个数
 n,k(1<=n, k<=100),接下来一行有2n个数a1,a2,...,a2n(1<=a1<=1000000000).
 表示原始牌组从上到下的序列.

 输出描述:对于每组数据,输出一行,最终的序列.数字之间用空格隔开,不要在行末输出多余空格

 输入样例:
 3
 3 1
 1 2 3 4 5 6
 3 2
 1 2 3 4 5 6
 2 2
 1 1 1 1
 输出样例:
 1 4 2 5 3 6
 1 5 4 3 2 6
 1 1 1 1
 */

public class ShuffleCards {
    private static String contronler(String line1, String line2){
        String[] str1 = line1.split(" ");
        String[] cards = line2.split(" ");
        int n = Integer.parseInt(str1[0]);
        int k = Integer.parseInt(str1[1]);
        String[] sortedCards = contronler(cards, n, k);
        int length = sortedCards.length;
        String result = "";
        for (int i = 0; i < length; i++){
            if (i != length - 1){
                result = result + sortedCards[i] + " ";
                continue;
            }
            result += sortedCards[i];
        }
        return result;
    }


    private static String[] contronler(String[] cards, int n, int k){
        if (k == 0){
            return cards;
        }
        int index = 0;
        String[] newCards = new String[2 * n];
        for (int i = 0; i < n; i++){
            newCards[index++] = cards[i];
            newCards[index++] = cards[n + i];
        }
        return contronler(newCards, n, k - 1);
    }



    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = 0;
        int count = 0;
        String[] results = new String[100];
        while (in.hasNext()){
            if (num == 0){
                num = Integer.parseInt(in.nextLine());
                results = new String[num];
            }

            String line1 = in.nextLine();
            String line2 = in.nextLine();
            results[count++] = contronler(line1, line2);


            if (count == num){
                break;
            }
        }

        for (int i = 0; i < num; i++){
            System.out.println(results[i]);
        }
    }
}
