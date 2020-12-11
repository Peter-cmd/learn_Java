package find;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
public class FindTheAppointScore {
    private static ArrayList<ArrayList<Integer>> lists = null;

    private static void findTheAppointScore() {

        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // 遍历所有的测试用例
        for (ArrayList<Integer> list : lists) {
            int size = list.size();
            // 遍历某一条测试用例
            for (int i = 0; i < size - 1; i++) {
                // 获取当前分数的学生人数, 若不存在置为 0
                int temp = map.getOrDefault(list.get(i), 0);
                // 将当前分数的学生人数加 1
                map.put(list.get(i), temp + 1);
            }
            // 将获得指定分数的学生的总个数进行保存
            result.add(map.get(list.get(size - 1)));
            map.clear();
        }

        lists.clear();
        // 遍历输出结果
        for (Integer i : result) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        lists = new ArrayList<>();
        ArrayList<Integer> list = null;
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(in.nextInt());
            }
            list.add(in.nextInt());
            lists.add(list);

        }
        findTheAppointScore();
    }
}