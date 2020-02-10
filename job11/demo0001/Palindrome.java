package job11.demo0001;
import java.util.List;
import java.util.ArrayList;
public class Palindrome {
    public boolean isPalindrome(String s){
        int length = s.length();
        char[] array = s.toCharArray();
        List<Character> list = new ArrayList<>();
        //将字符串中的非数字和非字母去除
        for (int i = 0; i < length; i++){
            if (array[i] >= '0' && array[i] <= '9'){
                list.add(array[i]);
            }
            if (array[i] >= 'a' && array[i] <= 'z'){
                list.add(array[i]);
            }
            if (array[i] >= 'A' && array[i] <= 'Z'){
                list.add((char)(array[i] - 'A' + 'a'));
            }
        }
        int left = 0;
        int right = list.size() - 1;
        //比较顺序表是否对称相等
        while (left < right){
            if (list.get(left) == list.get(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}
