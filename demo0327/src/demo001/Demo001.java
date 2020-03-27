package demo001;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Demo001 {

    public static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> list, int[] num, int i){
        ArrayList<Integer> list2 = new ArrayList<>();
        if (i == 0){
            return list2;
        }

        dfs(list, num, i);
        list.add(list2);
        list2.add(Integer.valueOf(num[i - 1]));
        return list2;
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[] nums = {1, 2, 3};
        dfs(list, nums, nums.length);
        System.out.println(list.toString());
    }
}
