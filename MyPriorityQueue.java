package test1124.MyPriorityQueue;

public class MyPriorityQueue {
    private int[] array = new int[100];
    private int size = 0;
    //向上调整队列
    public void shiftUp(int[] array, int index){
        while (index > 0){
            int parent = (index - 1) / 2;
            if (array[index] <= array[parent]){
                break;
            }
                swap(array,index,parent);
                index = parent;
        }
    }

    //交换队列元素
    public static void swap(int[] array, int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    //向下调整
    public void shiftDown(int[] array, int size, int index){
        int parent = index;
        int child = 2 * parent + 1;
        while (child < size){
            if (child + 1 < size && array[child] < array[child + 1]){
                child  = child + 1;
            }

            if (array[parent] > array[child]){
                break;
            }
            swap(array,child,parent);
            parent = child;
            child = 2 * parent + 1;
        }
    }
    //入队
    public void offer(int x){
        //处理队列已满的情况
        if (size >= array.length){
            return;
        }

        array[size] = x;
        size++;
        shiftUp(array,size - 1);
    }

    //出队
    public Integer poll(){
        //处理队为空的情况
        if (size == 0){
            return null;
        }

        int ret = array[0];
        array[0] = array[size - 1];
        shiftDown(array,size,0);
        return ret;
    }

    //返回队首元素
    public Integer peek(){
        //处理队为空的情况
        if (size == 0){
            return null;
        }
        //返回队首元素
        return array[0];
    }
}
