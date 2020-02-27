package merge_sort;

public class MergeSort {
    public static void mergeSort(int[] array){
       mergeSortHelper(array, 0, array.length);
    }

    private static void mergeSortHelper(int[] array, int left, int right){
        //递归结束边界
        if (left >= right - 1){
            return;
        }
        int mid = (left + right) / 2;
        mergeSortHelper(array, left, mid);
        mergeSortHelper(array, mid, right);
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right){
        int i = left;
        int j = mid;
        int k = 0;
        int length = right - left;
        int[] newArray = new int[length];
        while (i < mid && j < right){
            if (array[i] <= array[j]){
                newArray[k++] = array[i++];
            }else{
                newArray[k++] = array[j++];
            }
        }

        while(i < mid){
            newArray[k++] = array[i++];
        }

        while(j < right){
            newArray[k++] = array[j++];
        }

        for (int index = 0; index < length; index++){
            array[left + index] = newArray[index];
        }

    }

    public static void main(String[] args){
        int[] array = {1, 3, 2, 6, 5};
        mergeSort(array);
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}
