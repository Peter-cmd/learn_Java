package demo002;

import java.util.HashMap;
import java.util.Scanner;

/**
 *1. 中文大写金额数字前应标明"人民币"字样.
 * 中文大写金额数字应用壹（壹）、贰（贰）、
 * 叁、肆（肆）、伍（伍）、陆（陆）、柒、捌、
 * 玖、拾、佰、仟、万（万）、亿、元、角、分、
 * 零、整（正）等字样填写.
 *
 * 2.中文大写金额数字到"元"为止的,在"元"之后,
 * 应写"整字",如¥532.00应写成"人民币伍佰叁拾
 * 贰元整".在"角"和"分"后面不写"整"字.
 *
 * 3.阿拉伯数字中间有"0"时,中文大写要写"零"字,
 * 阿拉伯数字中间连续有几个"0"时,中文大写金额中
 * 间只写一个"零"字,如¥6007.14,应写成"人民币陆
 * 仟零柒元壹角肆分".
 *
 *
 * 输入描述:
 *   输入一个double数
 *
 * 输出描述:
 *   输出人民币格式
 *
 * 输入样例:
 *   151121.15
 * 输入样例:
 *   人民币拾伍万壹仟壹佰贰拾壹元壹角伍分
 *
 */

public class Main {
    private static HashMap<Integer, String> map = new HashMap<>();
    private static final int A_HUNDRED_MILLION = 100000000;
    private static final int TEN_THOUSAND = 10000;
    private static final int THOUSAND = 1000;
    private static final int HUNDRED = 100;

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            Double total = in.nextDouble();
            record();
            String result = iterpreter(total);
            System.out.println(result);

        }
    }

    //建立阿拉伯数字和其中文大写的映射
    private static void record() {
        map.put(0, "零");
        map.put(1, "壹");
        map.put(2, "贰");
        map.put(3, "叁");
        map.put(4, "肆");
        map.put(5, "伍");
        map.put(6, "陆");
        map.put(7, "柒");
        map.put(8, "捌");
        map.put(9, "玖");
        map.put(10, "拾");
        map.put(100, "佰");
        map.put(1000, "仟");
        map.put(10000, "万");
        map.put(100000000, "亿");
    }


    //将金额以 4 位一个字段的形式划分,分别解析后整合
    private static String iterpreter(Double total) {
        //创建一个StringBuilder对象, 保存最后返回结果
        StringBuilder sb = new StringBuilder();
        int length = 0;
        total = total % 1000000000;
        //亿级字段
        int aHundredThousand = (int)(total / A_HUNDRED_MILLION);  //处理亿位
        StringBuilder sb1 = operate(aHundredThousand, 0);
        length = sb1.length();
        if (length != 0) {
            while (sb1.toString().substring(length - 1).equals("零")) {

                sb1.deleteCharAt(length - 1);
                length = sb1.length();
            }
        }
        //万级字段
        int tenThousand = (int)(total % A_HUNDRED_MILLION / TEN_THOUSAND);  //处理万位
        StringBuilder sb2 = operate(tenThousand, 0);
        length = sb2.length();
        if (length != 0) {
            while (sb2.toString().substring(length - 1).equals("零")) {

                sb2.deleteCharAt(length - 1);
                length = sb2.length();
            }
        }
        //个级字段
        int thousand = (int)(total % TEN_THOUSAND);  //处理
        StringBuilder sb3 = operate(thousand, 0);
        length = sb3.length();
        if (length != 0) {
            while (sb3.toString().substring(length - 1).equals("零")) {

                sb3.deleteCharAt(length - 1);
                length = sb3.length();
            }
        }
        //1.若亿级字段存在(即不全为0, 全为零的情况: 0000)
        if (sb1.length() != 0){
            sb.append(sb1 + "亿");  //将字段的转译结果放入返回结果中
        }
        //2.若亿级字段存在, 且存在万级字段未满 4 位(即
        // 从低位到高位, 在最后一个不为0的位之后存在为 0 的高位. 如: 0010, 0101)
        //此时需要将连续的 0 位合并为一个 "零"
        if (tenThousand / 1000 == 0
                && sb1.length() != 0
                && sb2.length() != 0){
            sb.append("零");
        }

        //若万及字段存在,与 1. 同理
        if (sb2.length() != 0){
            sb.append(sb2 + "万");
        }

        //与 2. 同理
        if (thousand / 1000 == 0
                && sb2.length() != 0
                && sb3.length() != 0){
            sb.append("零");
        }

        //若个位字段存在
        if (sb3.length() != 0){
            sb.append(sb3 + "元");
        }

        //如果有的话处理小数位
        int decimal = (int)(total * 100 % 100);
        if (decimal == 0 && total != 0){  //无小数位
            sb.append("整");
        }else if (decimal != 0 && total != 0){  //有小数位
            sb.append(map.get(decimal / 10) + "角");  //处理 0.1 位, 即角
            sb.append(map.get(decimal % 10) + "分");  //处理 0.01 即分
        }
        return sb.insert(0, "人民币").toString();  //返回结果
    }

    //转译各字段对应的中文表示
    private static StringBuilder  operate(int subNum, int n){
        //用以返回各字段的转译结果
        StringBuilder sb  = new StringBuilder();
        //若字段全为 0 或超出字段范围, 返回
        if (subNum == 0 || n == 4){
            return sb;
        }
        //从低位向高位分解处理字段的各位,直到字段的最高位, 再返回
        sb.append(operate(subNum / 10, n + 1));
        int temp = subNum % 10;  //获取该位的值

        sb.append(map.get(temp));  //将该位的阿拉伯数字转译为 map 中的中文大写
        // 根据该字段的中各位的位置,添加相应的单位(若为0无需添加单位)
        if (temp == 0){
            return sb;
        }
        if (n == 1){
            if (temp == 1){  //若十位为 1 ,则省略
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append("拾");
        }else if (n == 2){
            sb.append("佰");
        }else if (n == 3){
            sb.append("仟");
        }
        return sb;
    }


}
