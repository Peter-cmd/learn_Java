package merge;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    private static <T extends Comparable<? super T>> void mergeSort(T[] array, int left, int right) {
        int size = right - left;
        if (size <= 1){
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid, right);
        merge(array, left, mid, right);
    }

    private static <T extends Comparable<? super T>> void merge(T[] array, int left, int mid, int right) {
        int m = mid;
        int l = left;
        List<T> list = new ArrayList<>();

        // 若两段数组的元素个数都不为0, 并合并两个有序数组为一个数组
        while (l < mid && m < right) {
            // 将两个数组中的较小者, 优先放入最后合并得到的数组中
            if (array[l].compareTo(array[m]) <= 0) {
                list.add(array[l]);
                l++;
            }else {
                list.add(array[m]);
                m++;
            }
        }

        // 将未合并的数组元素全部并入, 合并得到的数组中
        if (l < mid) {
            for (int i = l; i < mid; i++) {
                list.add(array[i]);
            }
        }

        if (m < right) {
            for (int i = m; i < right; i++) {
                list.add(array[i]);
            }
        }

        int size = list.size();

        // 将合并操作得到的数组元素置入原数组的对应位置
        for (int i = 0; i < size; i++) {
            array[left + i] = list.get(i);
        }

    }

    public static void main(String[] args){
        Integer[] array = {1, 4, 6, 3, 2, 7};
        // 待排序区间为[0, array.length)
        mergeSort(array, 0, array.length);
    }
}
