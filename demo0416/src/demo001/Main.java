package demo001;
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = Integer.parseInt(in.next());
            int l = Integer.parseInt(in.next());
            long[] nums = new long[n];
            //录入元素
            for (int i = 0; i < n; i++){
                nums[i] = Long.parseLong(in.next());
            }
            //将数组排序
            Arrays.sort(nums);
            //计算两相邻路灯间的最大距离
            long D = 0;
            for (int i = 0; i < n - 1; i++){
                D = Math.max(D, nums[i + 1] - nums[i]);
            }

            D = Math.max(D, nums[0] - 0);
            D = Math.max(D, l - nums[n - 1]);
            System.out.println(String.format("%.2f", (double)D / 2));
        }
    }
}