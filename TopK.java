package test1124.TopK;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopK {
    static class Pair implements Comparable<Pair>{
        public int n1;
        public int n2;
        public int sum;
        //构造方法
        public Pair(int n1,int n2){
            this.n1 = n1;
            this.n2 = n2;
            this.sum = n1 + n2;
        }

        @Override
        public int compareTo(Pair o) {

            if (this.sum > o.sum){
                return 1;
            }

            if (this.sum < o.sum){
                return -1;
            }

            return 0;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        //若k小于1,要找的数据不存在
        if (k < 1){
            return result;
        }
        //将前k个和最小的k对数字存入queue
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        for (int i = 0; i < nums1.length && i < k; i++){
            for (int j = 0; j < nums2.length && j < k; j++){
                Pair pair = new Pair(nums1[i],nums2[j]);
                 queue.offer(pair);
                 if (queue.size() > k){
                     queue.poll();
                 }
            }
        }
        //将queue中的数据导入
        while (!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            Pair pair = queue.poll();
            tmp.add(pair.n1);
            tmp.add(pair.n2);
            result.add(tmp);
        }
        return result;
     }
}
