package preK;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TopK {
    public static void sort(int[] a){
        int length = a.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int i = 0;
        for (i = 0; i < length; i++){
            queue.add(a[i]);
        }

        while (!queue.isEmpty()){
            a[--i] = queue.poll();
        }
    }

    public static void main(String[] args){
        int[] a = {1, 7, 3, 6, 5};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
