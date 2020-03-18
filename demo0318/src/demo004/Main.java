package demo004;

import java.util.Scanner;

public class Main {

    public static String addLongInteger(String addend, String augend){
        char[] addendChars = addend.toCharArray();
        char[] augendChars = augend.toCharArray();
        int lengthAd = addendChars.length;
        int lengthAu = augendChars.length;
        int carry = 0;  //进位标志
        StringBuilder sb = new StringBuilder();
        int i = lengthAd - 1, j = lengthAu - 1;
        int temp = 0;  //存放各位临时计算结果
        //从低位到高位遍历两个数的每一位,并进行相加(不足的位补0)
        while (i >= 0 || j >= 0){

            //若两个数的位数还能对应
            if (i >= 0 && j >= 0){
                temp = (addendChars[i] - 48) + (augendChars[j] - 48) + carry;  //两数的对应位相加
                sb.append(temp % 10);  //相加结果取余放入和的对应位
                carry = isCarred(temp);  //判断是否有进位,并更新
            }

            //若 addend 的位数小于 augend 的位数
            if (i < 0){
                temp = (augendChars[j] - 48) + carry;  //两数的对应位相加
                sb.append(temp % 10);  //相加结果取余放入和的对应位
                carry = isCarred(temp);  //判断是否有进位,并更新
            }

            //若 augend 的位数小于 addend 的位数
            if (j < 0){
                temp = (addendChars[i] - 48) + carry;  //两数的对应位相加
                sb.append(temp % 10);  //相加结果取余放入和的对应位
                carry = isCarred(temp);  //判断是否有进位,并更新
            }
            //进行下一位运算
            i--;
            j--;
        }

        if (carry == 1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public static int isCarred(int temp){
        if (temp / 10 == 1){  //判断是否有进位,并更新
            return 1;
        }
        return 0;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String addend = in.nextLine();
            String augend = in.nextLine();
            String result = addLongInteger(addend, augend);
            System.out.println(result);
        }
    }
}

//         9999999999999999999999999999999999999999999999999999999999
//                                               00000000000000111001
//        10000000000000000000000000000000000000000000000000000111000