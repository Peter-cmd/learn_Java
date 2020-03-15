package demo001;

import java.math.BigInteger;

public class Demo001 {
    public static void main(String[] args){
        BigInteger a = new BigInteger("1234567");
        BigInteger b = new BigInteger("2345566");
        System.out.println("加法操作:" + a.add(b));
        System.out.println("减法操作:" + a.subtract(b));
        System.out.println("乘法操作:" + a.multiply(b));
        System.out.println("除法操作:" + b.divide(a));
        System.out.println(getType(a.add(b)));
        System.out.println("较大的数:" + a.max(b));
        System.out.println("较小的数:" + a.min(b));
        BigInteger[] result = a.divideAndRemainder(b);
        System.out.println("商是:" + result[0] + "余数是:" + result[1]);

    }


    public static Object getType(Object o){
        return o.getClass().toString();
    }

}
