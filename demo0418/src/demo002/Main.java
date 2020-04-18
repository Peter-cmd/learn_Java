package demo002;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 问题描述:
 * 开发一个坐标计算工具,A表示向左移动,D表示向右移动,W表示
 * 向上移动,S表示向下移动.从(0,0)点开始移动,从输入字符串
 * 里面读取一些坐标,并将最终输入结果输出到输出文件里面.
 *
 * 输入:
 * 合法坐标为A (或者D或者W或者S)+数字(两位以内)
 * 坐标之间以;分隔.
 * 非法坐标需要进行丢弃.如AA10;A1A;$%$;YAD;等.
 * 下面是一个简单的例子 如:
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * 处理过程:
 * 起点(0,0)
 * + A10 = (-10,0)
 * + S20 = (-10,-20)
 * + W10 = (-10,-10)
 * + D30 = (20,-10)
 * + X = 无效
 * + A1A = 无效
 * + B10A11 = 无效
 * + 一个空不影响
 * + A10 = (10,-10)
 * 结果(10, -10)
 * 输入描述:
 * 一行字符串
 * 输出描述:
 * 最终坐标,以,分隔
 *
 * 输入:
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * 输出:
 * 10,-10
 */
public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String line = in.next();
            findCoordinate(line);
        }
    }

    //计算坐标
    private static void findCoordinate(String line) {
        int[] coordinate = {0,0};
        //将字符串 line 以 ; 进行分割
        String[] subString = line.split(";");
        //存储符合要求的字符串形式
        ArrayList<String> filteredSubStr = new ArrayList<>();
        //遍历 subString 数组,对输入进行筛选
        for (String string : subString){
            //判断输入是否合法(不能完全过滤不合法情况)
            if (string.length() == 3
                    && '0' <= string.charAt(1) && string.charAt(1) <= '9'
                    && '0' <= string.charAt(2) && string.charAt(2) <= '9'){
                filteredSubStr.add(string);
            }
        }
        //更加合法输入计算坐标
        String direction = null;
        int distance = 0;
        int length = filteredSubStr.size();

        for (int i = 0; i < length; i++){
            direction = filteredSubStr.get(i).substring(0, 1);
            distance = Integer.parseInt(filteredSubStr.get(i).substring(1));
            helper(direction, distance, coordinate);
        }
        //打印最终结果
        System.out.println("[" + coordinate[0] + "," + coordinate[1] + "]");
    }

    //辅助计算并修改坐标
    private static void helper(String direction, int distance, int[] coordinate){
        //根据方向对坐标进行计算
        switch(direction){
            case "A" :
                coordinate[0] -= distance;
                break;
            case "D" :
                coordinate[0] += distance;
                break;
            case "W" :
                coordinate[1] += distance;
                break;
            case "S" :
                coordinate[1] -= distance;
                break;
            default :
                break;

        }
    }
}
