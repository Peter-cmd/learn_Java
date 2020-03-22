package demo003;
/**
 问题描述:一个百万富翁遇到一个陌生人,陌生人找他谈了一个换钱的计划.该计划如下:
 我每天给你10万元,你第一天给我1分钱,第二天2分钱,第三天4分钱......
 这样交换30天后,百万富翁交出了多少钱?陌生人交出了多少钱?(注意一个是万元,一个是分)

 输入描述: 无

 输出描述: 输出两个整数,分别代表百万富翁交出的钱和陌生人交出的钱,富翁交出的钱
 以万元作单位, 陌生人交出的钱以分作单位.
 */
public class Main {
    public static void main(String[] args) {
        long strenger = 0;
        strenger = 10 * 30;
        long millionaire = 1;
        millionaire <<= 30;
        System.out.println(strenger + " " + (millionaire - 1));
    }
}
