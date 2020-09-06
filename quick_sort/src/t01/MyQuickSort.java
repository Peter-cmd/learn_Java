package t01;

import java.util.Arrays;

public class MyQuickSort {


    public static void main(String[] args) {
        Integer[] i = {1, 3, 5, 9, 6};
        String[] s = {"bbb", "aaa", "bba"};
        Double[] d = {2.0, 1.0, 5.0, 3.0};
        int left = 0;
        int rightI = i.length - 1;
        int rightS = s.length - 1;
        int rightD = d.length - 1;
        quickSort(i, left, rightI);
        quickSort(s, left, rightS);
        quickSort(d, left, rightD);
        System.out.println(Arrays.toString(i));
        System.out.println(Arrays.toString(s));
        System.out.println(Arrays.toString(d));

    }

    private static <T extends Comparable<? super T>> void quickSort(T[] array, int left, int right) {
        // 若待排序区间无元素
        if (left + 1 > right) {
            return;
        }
        // 获取
        int pivot = partition(array, left, right);
        quickSort(array, left, pivot - 1);
        quickSort(array, pivot + 1, right);

    }

    private static <T extends Comparable<? super T>> int partition(T[] array, int left, int right) {
        int mark = left;
        // 若待排序区间还有元素
        while (left < right) {
            // 若待排序区间还有元素,并且从右向左找第一个小于 array[mark] 的数
            while (left < right && array[right].compareTo(array[mark]) >= 0) {
                right--;
            }
            // 若待排序区间还有元素,并且从右向左找第一个小于 array[mark] 的数
            while (left < right && array[left].compareTo(array[mark]) <= 0) {
                left++;
            }

            // 交换 left 和 right 位置的元素
            swap(array, left, right);
        }

        // 交换 left 和 mark 位置的元素
        swap(array, left, mark);

        return left;
    }

    private static <T> void swap(T[] array, int left, int right) {
        T temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

}
