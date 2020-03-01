import java.util.Scanner;

public class Main {


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //读入字符串
        while(in.hasNext()){
            String a = in.next();
            String b = in.next();
            int count = 0;
            int lengthA = a.length();  //获取字符串的长度
            int lengthB = b.length();
            for (int index = 0; index <= lengthA; index++){
                //按下表切割a
                String str1 = a.substring(0, index);
                String str2 = a.substring(index, lengthA);
                String c = str1 + b + str2;
                int lengthC = lengthA + lengthB;
                boolean result = Main.isPalindrom(c, 0, lengthC - 1);
                if (result){
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    //判定是否回文
    public static boolean isPalindrom(String c,int left, int right){
        while (left <= right){
            if (c.charAt(left++) != c.charAt(right--)){
                return false;
            }
        }
        return true;
    }
}
