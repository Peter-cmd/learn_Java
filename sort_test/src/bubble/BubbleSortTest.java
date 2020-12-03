package bubble;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BubbleSortTest {


    private static <T extends Comparable<? super T>>  void bubbleSort(T[] array) {

        // 冒泡排序进行 n 趟
        for (int i = 0; i < array.length; i++) {
            // 有序区间 [length - i, length)
            // 无序区间 (0, length - i)
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }

    }

    public static void main(String[] args){
        Integer[] array = {1, 2, 4, 6, 3, 8};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
