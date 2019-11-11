package com.Test6;
import java.util.Scanner;
class GreatestCommonDivisor { //定义GreatestCommonDivisor类
    private int num1;  //私有属性
    private int num2;
    private int greatest_common_divisor;
    public GreatestCommonDivisor(){ }//无参构造函数
    public void setNum1(int num1) {
        this.num1 = num1;
    }  //给属性赋值方法
    public int getNum1() {
        return this.num1;
    }  //获得属性值得方法
    public void setNum2(int num2) {
        this.num2 = num2;
    }
    public int getNum2() {
        return this.num2;
    }
    public int getGreatest_common_divisor(){
        return greatest_common_divisor;
    }
    public void Swap() {  //确保num1的值小于num2的方法
        if (this.num1 > this.num2) {
            int temp;
            temp = this.num1;
            this.num1 = this.num2;
            this.num2 = temp;
        }
    }

    public void find_greatest_common_divisor() {  //找最大公约数的方法(辗转相除法)
        int temp = num2 / num1;
        while(temp > 0){
             temp = num2 % num1;
             num2 = num1;
             num1 = temp;
        }
        greatest_common_divisor = num2;  //num2为两个数的最大公约数
    }
}

public class Test6 extends GreatestCommonDivisor {  //定义Test6类继承GreatestCommonDivisor类
    //主函数
    public static void main(String[] args){
        Test6 a = new Test6();  //创建Test6类的对象a
        Scanner in = new Scanner(System.in);  //创建Scanner类的对象in
        System.out.println("请输入num1:");
        int num1 = in.nextInt();  //调用nextInt()方法
        a.setNum1(num1);
        System.out.println("请输入num2:");
        int num2 = in.nextInt();
        a.setNum2(num2);
        a.Swap();  //调用确保num1的值小于num2的方法
        a.find_greatest_common_divisor();
        System.out.println("最大公约数是:" +a.getGreatest_common_divisor());

    }
}
