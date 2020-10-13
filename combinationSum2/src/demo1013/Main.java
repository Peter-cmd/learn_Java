package demo1013;

import java.util.*;

public class Main {
    // 用以保存最后结果
    private static ArrayList<ArrayList<Integer>> result = null;
    // 用以保存中间结果
    private static ArrayList<Integer> item = null;
    // 当前数字的累加和
    private static int curSum = 0;
    // 去除重复的结果
    private static Set<String> distinct = null;
    // 查找组成某个数字的组合数
    public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // 初始化最终结果集
        result = new ArrayList<ArrayList<Integer>>();
        // 初始化中间结果
        item = new ArrayList<Integer>();
        // 初始化去重结果集
        distinct = new HashSet<>();
        // 回溯查找组合数
        backtrack(num, target, 0);
        return result;
    }

    // 回溯查找组合数
    private static void backtrack(int[] num, int target, int index){
        // 若当前累加数字达到目标值
        if (curSum == target){
            // 新建中间结果变量
            ArrayList temp = new ArrayList<Integer>(item);
            // 将累加过程所用的数字进行排序(升序)
            Collections.sort(temp);
            // 去除重复中间结果
            if (!distinct.contains(temp.toString())){
                result.add(temp);
                distinct.add(temp.toString());
            }
            return;
        }
        // 回溯查找组合数
        for (int i = index; i < num.length; i++){
            curSum += num[i];
            item.add(num[i]);
            backtrack(num, target, i + 1);
            curSum -= num[i];
            item.remove(item.indexOf(num[i]));
        }
    }

    public static void main(String[] args){
        int[] num = {100,10,-30,-70,60,-10,50};
        combinationSum2(num, -10);
        System.out.println(String.valueOf(result));
    }

}