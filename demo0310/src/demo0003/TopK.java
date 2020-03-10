package demo0003;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 问题描述:找出n个数里最小的k个
 * 输入描述: 每个测试输入包含空格分割的n+1个整数,最后一个整数为k值,n不超过100.
 * 输出描述: 输出n个整数里最小的k个数.升序输出
 *
 * 输入:
 * 3 9 6 8 -10 7 -11 19 30 12 23 5
 *
 * 输出:
 * -11 -10 3 6 7
 */
public class TopK {

    public static PriorityQueue<Integer> topK(int[] nums, int K){
        ArrayList<Integer> temp = new ArrayList<>();

        if (K < 0 || K == 0){
            return null;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(K, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        int length = nums.length;
        for (int i = 0; i < length; i++){
            if (maxHeap.size() != K){
                maxHeap.offer(nums[i]);
            }else{
                if (maxHeap.peek() > nums[i]){
                    Integer temp1 = maxHeap.poll();
                    temp1 = null;
                    maxHeap.offer(nums[i]);
                }
            }
        }

        while (!maxHeap.isEmpty()){
            temp.add(maxHeap.poll());
        }

        PriorityQueue<Integer> result = new PriorityQueue<>(temp);
        return result;

    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int length = 0;
        int[] nums;
        int K = 0;
        while (in.hasNext()){
            String str = in.nextLine();
            String[] substring = str.split(" ");
            length = substring.length;
            K = Integer.parseInt(substring[length - 1]);
            nums = new int[length - 1];
            for (int i = 0; i < length - 1; i++){
                nums[i] = Integer.parseInt(substring[i]);
            }
            Queue<Integer> result = topK(nums, K);
            for (Integer integer : result){
                System.out.print(integer + " ");
            }

        }
    }
}
