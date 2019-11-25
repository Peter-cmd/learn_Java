package test1124.Sort;

public class Sort {
    //直接插入排序
    public static void insertOrder(int[] array){
        //将数组分为已排序区间[0,bound)和待排序区间[bound,array.length)
        for (int bound = 1; bound < array.length; bound++){
            int tmp = array[bound];
            int cur = bound - 1;
            //查找要插入的位置
            for (; cur >= 0; cur--){
                if (tmp < array[cur]){
                    array[cur + 1] = array[cur];  //将元素向后移动
                }else{
                    break;
                }
            }
            array[cur + 1] = tmp;  //将元素插入找到的位置
        }
    }
    //希尔排序
    public static void shellOrder(int[] array){
        int gap = array.length;
        while (gap > 1){
            //调用辅助排序方法
            insertSortGap(array,gap);
            gap = gap / 2;
        }
        insertSortGap(array,1);
    }
    //辅助希尔排序
    private static void insertSortGap(int[] array, int gap){
        for (int bound = 1; bound < array.length; bound++){
            int tmp = array[bound];
            int cur = bound - gap;
            //查找要插入的位置
            for (;cur >= 0; cur -= gap){
                if (tmp < array[cur]){
                    array[cur + gap] = array[cur];  //将元素向后移动
                }else{
                    break;
                }
            }
            array[cur + gap] = tmp;  //将元素插入找到的位置
        }
    }

    //选择排序
    public static void selectSort(int[] array){
        for (int bound = 0 ; bound < array.length; bound++){
            //bound位置元素为擂主
            for (int cur = bound + 1; cur < array.length; cur++){
                //若擂主元素比攻擂元素大
                if (array[bound] > array[cur]){
                    //更新擂主元素
                    swap(array,bound,cur);
                }
            }
        }
    }

    //交换方法
    private static void swap(int[] array, int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    //冒泡排序
    public  static void bubbleSort(int[] array){
        for (int bound = 0; bound < array.length; bound++){
            for (int cur = array.length - 1; cur > bound; cur++){
                if (array[cur] < array[cur - 1]){
                    swap(array,cur,cur - 1);
                }
            }
        }
    }

    //快速排序
    public static void quickSort(int[] array){
        int left = 0;
        int right = array.length - 1;
        quickSortHelper(array,left,right);

    }
    //辅助快速排序
    private static void quickSortHelper(int[] array, int left, int right){
        if (left >= right){
            return;
        }

        int index = partition(array,left,right);
        quickSortHelper(array,left,index - 1);
        quickSortHelper(array,index + 1, right);
    }
    //
    private static int partition(int[] array,int left,int right){
        int baseIndex = right;
        int baseValue = array[baseIndex];
        while (left < right){
            while (left < right && array[left] <= baseValue){
                left++;
            }

            while (left < right && array[right] >= baseValue){
                right--;
            }
            swap(array,left,right);
        }
        swap(array,left,baseIndex);
        return baseIndex;
    }

    public static void main(String[] args){
        int[] array = {9,5,2,7};
        shellOrder(array);
    }

}
