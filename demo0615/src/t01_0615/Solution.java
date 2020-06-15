package t01_0615;

public class Solution {
    public static void main(String[] args){

        Integer[] array = {1,2,7,5,3};
        int left = 0;
        int right = array.length - 1;
        quickSort(array, left, right);
        System.out.println();
    }

    private static <T extends Comparable<? super T>> void quickSort(T[] array, int left, int right) {
        if (left + 1 >= right){
            return;
        }

        int pivot = partition(array, left, right);
        quickSort(array, left, pivot - 1);
        quickSort(array, pivot + 1, right);
    }

    private static <T extends Comparable<? super T>> int partition(T[] array, int left, int right) {
        int position = left;
        while(left < right) {
            while (left < right && array[position].compareTo(array[right]) <= 0) {
                right--;
            }
            while (left < right && array[position].compareTo(array[left]) >= 0) {
                left++;
            }
            swap(array, left, right);
        }
        swap(array, left ,position);
        return left;
    }

    private static <T> void swap(T[] array, int left, int right) {
        T t = array[left];
        array[left] = array[right];
        array[right] = t;
    }
}
