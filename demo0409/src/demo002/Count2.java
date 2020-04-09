package demo002;
/**
 *问题描述: 请编写一个方法,输出0到n(包括n)中数字2出现了几次.
 * 给定一个正整数n,请返回0到n的数字中2出现了几次.
 *
 * 输入样例:
 * 10
 *
 * 输出样例:
 * 返回: 1
 */
public class Count2 {
    public int countNumberOf2s(int n) {
        //创建一个变量 count 用以保存 2 出现的次数
        int count = 0;
        //复制 n 的值,以便操作
        int temp = n;
        //累积 n 的位数
        int mult10 = 1;
        int cur = 0;
        int low = 0;
        int high = 0;
        while (temp / mult10 != 0){
            low = temp - (temp / mult10) * mult10;
            cur = temp / mult10 % 10;
            high = temp / (mult10 * 10);

            switch(cur){
                case 0 :
                case 1 :
                    count += high * mult10;
                    break;
                case 2 :
                    count += high * mult10 + low + 1;
                    break;
                default:
                    count += (high + 1) * mult10;
                    break;
            }

            mult10 *= 10;
        }

        return count;
    }
}
