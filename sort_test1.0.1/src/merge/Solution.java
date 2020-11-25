package merge;

public class Solution {

    private static void mergeSort(Integer[] array, int left, int right) {
        int size = right - left;
        if (size <= 1) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid, right);
        merge(array, left, mid, right);

    }


    private static void merge(Integer[] array, int left, int mid, int right) {
        int l = left;
        int m = mid;
        int[] temp = new int[right - left];
        int i = 0;
        while (l < mid && m < right) {
            if (array[l] <= array[m]) {
                temp[i] = array[l];
                i++;
                l++;
            }else {
                temp[i] = array[m];
                i++;
                m++;

            }
        }


    }

    public static void main(String[] args){
        Integer[] array = {1, 4, 6, 3, 2, 7};
        mergeSort(array, 0, array.length);
    }
}
