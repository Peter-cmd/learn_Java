package job01.demo0002;

import java.util.Scanner;

public class Solution {
    public String toLowerCase(String str){
        char[] data = str.toCharArray();
        for (int i = 0; i < data.length; i++){
            if (data[i] >= 'A' && data[i] <= 'Z') {
                data[i] = (char) (data[i] + 32);
            }
        }
        return new String(data);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        str = solution.toLowerCase(str);
        System.out.println(str);
    }
}
