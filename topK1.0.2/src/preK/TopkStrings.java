package preK;

import java.util.*;

public class TopkStrings {

//    // 查找出现次数前k名的字符串
//    public static String[][] topKstrings1(String[] strings, int k) {
//        // write code here
//
//        // 记录每个字符串的出现次数
//        Map<String, Integer> map = new HashMap<>();
//        // 保存经过排序的字符串数组
//        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>();
//        // 遍历字符串数组, 统计字符串出现的次数
//        for (String string : strings) {
//            if (!map.containsKey(string)) {
//                map.put(string, 1);
//            }else {
//                map.put(string, (map.get(string) + 1));
//            }
//        }
//        // 将字符串数组中,各字符串出现次数的统计结果存入list
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            list.add(entry);
//        }
//        // 将list中的元素进行降序排序
//        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                if (o1.getValue() == o2.getValue()) {
//                    return o1.getKey().compareTo(o2.getKey());
//                }
//                return o2.getValue() - o1.getValue();
//            }
//        });
//        // 记录最终的结构并进行返回
//        String[][] result = new String[k][2];
//        for (int i = 0; i < k; i++){
//            result[i][0] = list.get(i).getKey();
//            result[i][1] = list.get(i).getValue() + "";
//        }
//        return result;
//    }

    public static String[][] topKstrings2(String[] str, int k) {
        Map<String, Integer> map = new TreeMap<>();

        Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue() - o1.getValue();
            }
        };


        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(comparator);

        for (String string : str) {
            if (!map.containsKey(string)) {
                map.put(string, 1);
            }else {
                map.put(string, (map.get(string) + 1));
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.add(entry);
        }

        String[][] result = new String[k][2];
        int i = 0;
        while (!queue.isEmpty() && i < k) {
            Map.Entry<String, Integer> entry = queue.poll();
            result[i][0] = entry.getKey();
            result[i++][1] = entry.getValue() + "";
        }
        return result;
    }

    public static void main(String[] args) {
        String[] str = {"123", "123", "234", "345", "345", "345", "789"};
        String[][] result = topKstrings2(str, 3);
        for (String[] item : result) {
            System.out.println(Arrays.toString(item));
        }
        ArrayList<Integer> in = new ArrayList<>();

    }

}
