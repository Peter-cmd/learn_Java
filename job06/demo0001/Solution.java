package job06.demo0001;

public class Solution {
    public int lengthOfLastWord(String s){
        String str = s.trim();
        int count = 0;
        int end = str.length() - 1;
        while(end >= 0){
            if(str.charAt(end) != ' '){
                count++;
            }else {
                break;
            }
            end--;
        }
        return count;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String s = "hello world ";
        int result = solution.lengthOfLastWord(s);
        System.out.println(result);
    }
}
