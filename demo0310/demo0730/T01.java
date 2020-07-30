package t01;
import java.util.*;
public class T01 {
        /**
         *
         * @param n int整型
         * @param a int整型一维数组
         * @return int整型
         */
        public int work (int n, int[] a) {
            // write code here
            // 1.每个牛牛居住的村庄都要建车站
            int minCount = n;
            // 两相邻车站间的距离
            int distance = 0;
            for (int i = 1; i < a.length ; i++){
                distance = a[i] - a[i - 1];

                // 2.相邻车站的距离必须为1或某个质数:
                //   a.判断两相邻车站间的距离是否为1或质数;
                //   b.若车站之间的距离符合要求,不做处理;
                if (distance == 1 || isPrime(distance))
                    continue;
                //   c.若车站之间的距离不符合要求,在两车站之间寻找
                //   合适的质数,修建新的车站
                // 根据欧拉版的哥德巴赫猜想:
                // 任意大于 2 的偶数都可以写成两个质数的和;
                if (distance % 2 == 0){
                    minCount += 1;
                }else{
                    minCount += 2;
                    if (isPrime(distance - 2)){
                        minCount -= 1;
                    }

                }


            }

            return minCount + 1;
        }

       //  判断一个数是不是素数
        public static boolean isPrime(int num) {
            int sqrt = (int)Math.sqrt(num);
            while (sqrt > 1){
                if (num % sqrt == 0){
                    return false;
                }
                sqrt--;
        }
        return true;
    }
}
