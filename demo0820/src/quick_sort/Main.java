package quick_sort;

public class Main {



    private static <T extends Comparable<? super T>> void quickSort(T[] array, int left, int right){
        if (left + 1 > right){
            return;
        }

        int pivot = partition(array, left, right);
        quickSort(array, left, pivot - 1);
        quickSort(array, pivot + 1, right);
    }

    private static <T extends Comparable<? super T>> int partition (T[] array, int left, int right){
        int mark = left;

        while (left < right){
            while (left < right && array[right].compareTo(array[mark]) >= 0 ){
                right--;
            }
            while (left < right && array[left].compareTo(array[mark]) <= 0){
                left++;
            }

            swap(array, left, right);
        }
        swap(array, mark, left);
        return left;
    }

    private static <T> void swap(T[] array, int left, int right) {
        T temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args){
        Integer[] nums = {1, 3, 5, 2, 6};
        Double[] num2 = {1.0, 2.0, 5.0, 3.0, 10.0, 8.0};
        int left = 0;
        int right = num2.length - 1;
        quickSort(num2, left, right);
        System.out.println();
    }
}
