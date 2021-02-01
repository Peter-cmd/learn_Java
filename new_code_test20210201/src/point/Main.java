package point;

import java.util.Scanner;

/**
 * 实现一个简易的坐标计算工具
 */

public class Main {
    // 判定输入数据的长度是否合格
    private static boolean judgeLength(String operation) {
        return operation.length() == 3 || operation.length() == 2;
    }

    // 计算输入数据中的坐标偏移量
    private static int count(String operation) {
        int result = 0;
        // 判定偏移量是个位数还是两位数
        if (operation.charAt(1) >= '1' && operation.charAt(1) <= '9') {
            // 偏移量为两位数
            if (operation.length() == 3 && operation.charAt(2) >= '0' && operation.charAt(2) <= '9') {
                result += Integer.parseInt(operation.substring(1, 3));
            }else if (operation.length() == 2){  // 偏移量是个位数
                result += Integer.parseInt(operation.substring(1, 2));
            }

        }
        // 返回无符号的偏移量
        return result;
    }

    private static int[] operator(String[] operations) {
        int[] point = new int[2];
        // 遍历存储坐标偏移操作的数组, 并计算最终坐标
        for (int i = 0; i < operations.length; i++) {
            // 判定偏移操作(输入数据的长度)是否合格
            if (judgeLength(operations[i])) {
                // 计算坐标偏移量
                char type = operations[i].charAt(0);
                // 根据操作符号的类型进行偏移操作, 即对坐标进行计算
                if (type == 'A') {
                    point[0] -= count(operations[i]);
                }

                if (type == 'D') {
                    point[0] += count(operations[i]);
                }

                if (type == 'S') {
                    point[1] -= count(operations[i]);
                }

                if (type == 'W') {
                    point[1] += count(operations[i]);
                }
            }
        }
        return point;
    }


    public static void main(String[] args) {
        // 处理输入数据, 并调用坐标计算函数和打印最终结果
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String line = in.nextLine();
            String[] operations = line.split(";");
            int[] result = operator(operations);
            System.out.println(result[0] + "," + result[1]);
        }
    }
}