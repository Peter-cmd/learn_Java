package logest.substring;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
class Solution {
    public static int lengthOfLongestSubstring(String s) {
        // 保存字符数组字符出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        // 将字符串转化为字符数组
        char[] chars = s.toCharArray();
        // 获取字符串的长度
        int length = chars.length;
        int i = 0, j = 0;
        int temp;
        int result = 0;
        // 若 j 小于字符数组的长度
        while (j < length){
            // 将字符转化为 int 型
            temp = chars[j] - 0;
            // 判断当前 map 中是否含有当前字符
            if (!map.containsKey(temp)){  // 若当前 map 中不包含 temp
                map.put(temp, j + 1);  // 以当前的 temp 为 key, 当前 temp 的下标加 1 为 value
            }else{  // 若当前 map 包含 temp
                // 更新 i 为 i 和 当前 map.get(temp) 中较大者
                i = Math.max(i, map.get(temp));
                // 更新 map 中 key 为 temp 的 value 为 j + 1
                map.put(temp, j + 1);
            }
            // 计算并保存虽大的字符串子串
            result = Math.max(result, j - i + 1);
            // 继续遍历数组
            j++;
        }
        return result;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while (in.hasNext()){
            String str = in.nextLine();
            int result = lengthOfLongestSubstring(str);
            System.out.println(result);
        }
    }
}