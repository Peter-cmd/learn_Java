package demo002;

/**
 问题描述:春节期间小明使用微信收到很多个红包,非常开心.在查看领取红包记录时发
 现,某个红包金额出现的次数超过了红包总数的一半.请帮小明找到该红包金额.写出具体
 算法思路和代码实现,要求算法尽可能高效.
 给定一个红包的金额数组gifts及它的大小n,请返回所求红包的金额.
 若没有金额超过总数的一半,返回0.
 测试样例:
 [1,2,3,2,2],5

 返回: 2

 */

import java.util.*;

public class Gift {
    public int getValue(int[] gifts, int n) {
        // write code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int halfOfN = n / 2 ;
        int length = gifts.length;
        //遍历数组每一个元素,统计其出现的次数,并存到map中
        for (int i = 0; i < length; i++){
            //若map中不包含该元素
            if (!map.containsKey(gifts[i])){
                map.put(gifts[i], 0);
            }else{
                map.put(gifts[i], map.get(gifts[i]) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() > halfOfN){
                return entry.getKey();
            }
        }
        return 0;
    }
}
