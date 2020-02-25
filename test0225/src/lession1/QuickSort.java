package lession1;

public class QuickSort {
    public static void quickSort(int[] array, int left, int right){
       if (left >= right){
           return;
       }

       int povit = partition(array, left, right);
       quickSort(array, left, povit);
       quickSort(array, povit + 1, right);
    }

    public static int partition(int[] array, int left, int right){
        int index = left;
        while(left < right){
            while (left < right && array[--right] > array[index]);
            while (left < right && array[++left] < array[index]);
            swap(array, left, right);
        }
        swap(array, left, index);
        return left;
    }

    public static void swap(int[] array, int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static void main(String[] args){
        int[] array = {1, 2, 4, 9, 5};
        int left = 0;
        int right = array.length;
        quickSort(array, left, right);
        return;
    }
}
