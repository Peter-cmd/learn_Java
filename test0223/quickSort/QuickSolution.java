package test0223.quickSort;

public class QuickSolution {
    public static void quickSort(int[] array, int left, int right){
        if (left >= right){
            return;
        }
        int povit = partition(array, left, right);
        quickSort(array, left, povit - 1);
        quickSort(array, povit + 1, right);
    }

    public static int partition(int[] array, int left, int right){
        int tar = left;
        while (left < right){
            while (left < right && array[right] > array[tar]){
                right--;
            }
            while (left < right && array[left] < array[tar]){
                left++;
            }
            swap(array, left, right);

            }
            swap(array, left, tar);
        return left;
    }

    public static void swap(int[] array, int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;

    }
    public static void main(String[] args){
        int[] array = {1, 9, 7, 6, 3};
        int left = 0;
        int right = array.length - 1;
        quickSort(array, left, right);
        return;
    }
}
