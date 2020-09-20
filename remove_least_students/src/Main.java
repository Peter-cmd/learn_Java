import java.util.Scanner;
public class Main{

    // 查找需要移除的最少学生数
    private static void removeLeastStudents(int n, int[] nums){
        int[] left = new int[n];
        int[] right = new int[n];
        // 从左向右找最长的山峰数子序列
        // 山峰数类似 12354321
        for (int i = 0; i < n; i++){
            // 每一个数都是一个山峰数
            left[i] = 1;
            for (int j = 0; j < i; j++){
                // 若当前数之前有比其小的数,则可与该数构成山峰数
                // 此过程只考虑升序
                if (nums[j] < nums[i]){
                    left[i] = Math.max(left[i], left[j] + 1);
                }
            }
        }
        // 从右向左找最长的山峰数子序列
        for (int i = n - 1; i >= 0; i--){
            right[i] = 1;
            for (int j = n - 1; j > i; j--){
                // 同样只考虑升序
                if (nums[j] < nums[i]){
                    right[i] = Math.max(right[i], right[j] + 1);
                }
            }
        }
        int result = 0;
        // 计算最大的山峰数子序列,其中当前位置的数出现了两次,需要减 1
        for (int i = 0; i < n; i++){
            result = Math.max(result, left[i] + right[i] - 1);
        }
        // 总的人数减去最大的山峰数子序列就是要出列的学生
        System.out.println(n - result);
    }


    // 处理输入
    public static void main(String[] agrs){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            // 学生总的个数
            int n = in.nextInt();
            // 用来记录每个学生的身高
            int[] nums = new int[n];
            for (int i = 0; i < n; i++){
                nums[i] = in.nextInt();
            }
            removeLeastStudents(n, nums);
        }
    }
}