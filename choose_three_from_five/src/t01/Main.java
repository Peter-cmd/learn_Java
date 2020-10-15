package t01;

import java.util.Stack;

public class Main {

    private static Stack<Integer> stack = new Stack<>();
    private static int[] array = new int[3];
    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4, 5};
        deal(nums, 0,0);

    }

    private static void deal(int[] nums, int n, int index) {
        int length = nums.length;
//        // 若栈的长度为 3, 打印结果并返回
//        if (stack.size() == 3){
//            System.out.println(stack);
//            return;
//        }
//        // 循环从 index 处开始
//        for (int i = index; i < length; i++){
//            // 元素进栈
//            stack.push(nums[i]);
//            // 深度遍历,且循环从 i + 1 出开始
//            deal(nums, i + 1);
//            // 元素出栈
//            stack.pop();
//        }

        if (n == 3){
            for (int i = 0; i < 3; i++){
                System.out.print(array[i]);
            }
            System.out.println();
            return;
        }

        for (int i = index; i < length; i++){
            array[n] = nums[i];
            n++;
            deal(nums, n, i + 1);
            n--;
        }
    }

}
