package lession01;

public class QuickSort {
    public static void main(String[] args){
        int[] array = {1, 4, 5, 6, 2};
        int left = 0;
        int right = array.length;
        quickSort(array, left, right);

        return;
    }

    public static void quickSort(int[] array, int left, int right){
        if (left >= right){
            return;
        }

        int pivot = partition(array, left, right);
        quickSort(array, left, pivot);
        quickSort(array, pivot + 1, right);

    }

    public static int partition(int[] array, int left, int right){
        int mark = left;
        while (left < right){
            while (left < right && array[--right] > array[mark]);
            while (left < right && array[++left] < array[mark]);
            swap(array, left, right);
        }
        swap(array, left, mark);
        return left;

    }

    public static void swap(int[] array, int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
