package demo02;

public class Main {
    public static void removeZeros(String str, int k){
        if (str == null || k < 1){
            System.out.println(str);
        }
        char[] chars = str.toCharArray();
        int length = chars.length;
        int count = 0;
        int start = -1;
        int temp = 0;
        for (int i = 0; i != length; i++){
            if (chars[i] == '0'){
                count++;
                start = start == -1 ? i : start;
            }else{
                if (count == k){
                    temp = count;
                    while (count-- != 0){
                        chars[start++] = 0;
                    }
                }
                count = 0;
                start = -1;
            }

        }
        if (count == k){
            while (count-- != 0){
                chars[start++] = 0;
            }
        }
        System.out.println(String.valueOf(chars));
    }

    public static void main(String[] args){
        String str = "A00B";
        int k = 2;
        removeZeros(str, k);

    }
}
