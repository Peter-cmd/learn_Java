package simple;

import java.util.Scanner;

class Solution {
    public String reverseLeftWords(String s, int n) {
        // 创建可修改的字符串序列对象
        StringBuilder sb = new StringBuilder();
        // 将字符串 s 添加到字符串序列对象中
        sb.append(s);
        // 将字符串对象 s 再次加入字符串序列对象中
        sb.append(s);
        // 将字符串序列转成字符串, 并以区间 [n, s.length() + n)
        return sb.toString().substring(n, s.length() + n);
    }

    public static void main(String[] args){
        String str;
        int n;
        Scanner in = new Scanner(System.in);
        Solution solution = new Solution();
        while(in.hasNext()) {
            str = in.nextLine();
            n = in.nextInt();
            // 接收 nextInt() 留下的换行符
            in.nextLine();
            String result = solution.reverseLeftWords(str, n);
            System.out.println(result);
        }
    }
}
