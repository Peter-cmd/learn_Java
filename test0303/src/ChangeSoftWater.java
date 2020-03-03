import java.util.Scanner;

/**
 * 三个空瓶换一瓶汽水
 * 若借一瓶可换,可以先借一瓶
 * 输入n,代表空瓶数
 * 最多输入 10 组数据
 * 输入格式:
 * 3
 * 10
 * 81
 * 0
 * 数出格式:
 * 1
 * 5
 * 40
 * 输入0代表结束,不做处理
 */
public class ChangeSoftWater {

    //计算可换得的汽水数
    public static void count(int[] A, int size){
        //循环处理数组中的左右元素
        for (int i = 0; i < size; i++){
            if (A[i] == 0){  //若空瓶数为0
                return;
            }

            //若空瓶数不为0
            int availableSoftWater = 0;  //当前换得的总汽水个数
            int emptyBottle = A[i];  //空瓶个数
            int drinkedSoftWater = 0;
            while (emptyBottle / 3 != 0){  //若空瓶的个数大于3
                availableSoftWater = emptyBottle / 3;  //当前可换得的汽水个数
                drinkedSoftWater += availableSoftWater;  //已经喝了的汽水数
                emptyBottle = emptyBottle % 3 + availableSoftWater;  //当前的空瓶数
            }
            //若还剩两个空瓶,可先借1瓶再换3个空瓶
            if (emptyBottle == 2){
                drinkedSoftWater += 1;
            }
            A[i] = drinkedSoftWater;  //将数组对应下标位置的空瓶数更新为可换得的汽水数
        }
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] input = new int[10];  //创建一个数组保存10个输入元素
        int i = 0;  //记录数组实际元素个数
        while(i < 10) {
            int temp = in.nextInt();  //读取一个数据
            if (temp == 0){  //若所读数据为0,跳出循环
                break;
            }
            input[i++] = temp;  //否则保存数据
        }
        count(input, i);
        //循环打印结果
        for (int j = 0; j < i; j++){
            System.out.println(input[j]);
        }
    }
}
