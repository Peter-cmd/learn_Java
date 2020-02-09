package job10.demo0003;

public class AddBinarrySolution {
    public static String addBinary(String a, String b){
        int lengthA = a.length();
        int lengthB = b.length();
        StringBuffer sb = new StringBuffer();
        if (lengthA == 0){  //若 a 为空,返回 b
            return b;
        }

        if (lengthB == 0){  //若 b 为空,返回 a
            return a;
        }
        int i = lengthA - 1;
        int j = lengthB - 1;
        int tag = 0;  //进位标志(0代表无进位, 1代表有进位)
        //处理二进制相加的每一位
        while (i >= 0 || j >= 0){
            if (i >= 0){  //若未遍历到 a 的首元素
                tag += a.charAt(i--) - 48;  //注意0的ascii码为48,所以charAt()方法获得的字符元素应减48
            }
            if (j >= 0){  //若未遍历到 b 的首元素
                tag += b.charAt(j--) - 48;
            }
            sb.append(tag % 2);  //将该二进制位加入StringBuffer类的对象中
            tag /= 2;  //更新进位标志
        }
        if (tag == 1){  //若最高位有进位,最高位为1
            sb.append(1);
        }
        return sb.reverse().toString();  //先将 sb 中的内容逆置,在转化为字符串返回
    }

    public static void main(String[] args){
        String a = "1010";
        String b = "1011";
        String c = AddBinarrySolution.addBinary(a , b);
        System.out.println(c);
    }

}
