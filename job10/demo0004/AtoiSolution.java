package job10.demo0004;

public class AtoiSolution {
    public static int myAtoi(String str){
        str =  str.trim();  //去掉首尾的空格
        //处理字符串为空或全为空格的情况
        if (str.length() == 0){
            return 0;
        }
        //查看字符串第一个非空格的元素
        char firstChar = str.charAt(0);
        //处理第一个字符非数字,非正号,非负号的情况
        if (firstChar < '0' || firstChar > '9'){
            if (firstChar != '+' && firstChar != '-') {
                return 0;
            }
        }

        //处理正常情况
        int sign = 1;  //(默认为1)用来和数字相乘表示正负(若为正,为1;反之为-1)
        if (firstChar == '-'){  //若该数为负数,则将 sign 更新为 -1
            sign = -1;
        }
        int i = 0;
        if (firstChar == '+' || firstChar == '-'){  //若第一个字符为符号,则跳过第一个字符
            i = 1;
        }
        StringBuffer sb = new StringBuffer();
        for (; i < str.length(); i++){  //遍历字符串的每一个字符
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                sb.append(str.charAt(i));
            }else{
                break;
            }
        }
        long rev = 0;
        for (int index = 0; index < sb.length(); index++){
            rev  = rev * 10 + sb.charAt(index) - 48;  //将字符转化为整数
            if (rev * sign < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            if (rev * sign> Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
        }
        rev = rev * sign;

        return (int)rev;
    }

    public static void main(String[] args){
        String str = "3.14159";
        int result = AtoiSolution.myAtoi(str);
        System.out.println(result);
    }
}
