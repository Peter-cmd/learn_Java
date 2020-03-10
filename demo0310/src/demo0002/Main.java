package demo0002;

import java.util.Scanner;

/**
 * 有一个数组a[N]顺序存放0~N-1,要求每隔两个数删掉一个数,到末尾
 * 时循环至开头继续进行,求最后一个被删掉的数的原始下标位置.以8个
 * 数(N=7)为例:{0,1,2,3,4,5,6,7}, 0->1->2(删除)->3->4->5(删除)
 * ->6->7->0(删除),如此循环直到最后一个数被删掉.
 *
 * 输入样例:
 * 8
 *
 * 输出样例:
 * 6
 */

public class Main {

    public static int indexOfLastNum(int n){
        boolean[] nums = new boolean[n];  //记录已删除的元素和未删除的元素

        int count = n;  //待删除的元素个数
        int lastIndex = -1;  //最后要返回的下标
        int stepCount = 0;  //步长计数器
        final int step = 2;  //指定删除步长
        int i = 0;  //遍历数组的游标
        while (count != 0){  //若但删除元素不为0
            if (!nums[i]){  //若要删除位置的元素未删除
                if (stepCount++ == step){  //若步长计数器加1等于指定的删除步长
                    nums[i] = true;  //删除该下标元素
                    count--;  //待删除元素减1
                    lastIndex = i;  //要返回的最后删除元素下标更新
                    stepCount = 0;  //步长计数器置0
                }
            }
            i = (i + 1) % n;  //i遍历数组,若超出数组长度取余(即循环遍历数组)
        }
        return lastIndex;
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int result = indexOfLastNum(n);
            System.out.println(result);
        }
    }
}
