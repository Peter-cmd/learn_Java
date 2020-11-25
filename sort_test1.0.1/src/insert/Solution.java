package insert;

import java.util.Arrays;

public class Solution {
    private static <T extends Comparable<? super T>> void insert_sort(T[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            int j = i - 1;
            T temp = array[i];
            for (; j >= 0 && array[j].compareTo(temp) > 0; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = temp;
        }
    }

    public static void main(String[] args){
        Integer[] array = {1, 4, 6, 7, 3, 2, 1};
        insert_sort(array);
        Arrays.toString(array);
    }

}
