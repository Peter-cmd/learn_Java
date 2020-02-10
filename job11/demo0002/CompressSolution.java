package job11.demo0002;

import java.util.Stack;
class CompressSolution{
        public static int compress(char[] chars){
            int[] array = new int[128];
            Stack<Integer> stack = new Stack<>();
            int length = chars.length;
            int index = 0;
            int temp = 0;
            char[] copyChars = new char[length + 1];
            for (int i = 0; i < length; i++){
                copyChars[i] = chars[i];
            }
            for (int i = 0; i < length; i++) {
                array[copyChars[i]]++;
                if (copyChars[i] != copyChars[i + 1]) {  //若当前字符与其之后第一个字符不相等
                    chars[index++] = copyChars[i];  //将当前字符存入数组
                    temp = array[copyChars[i]];  //获取当前字符连续出现次数
                    if (temp > 1){  //若当前字符出现次数大于1,将其存入数组
                        while (temp > 0) {
                            stack.add(temp % 10);
                            temp /= 10;
                        }
                        while (!stack.empty()) {
                            chars[index++] = (char) (stack.pop() + 48);
                        }
                    }
                    array[copyChars[i]] = 0;  //将数组出现次数清零
                }
            }
            return index;
        }
    public static void main(String[] args){
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int result = CompressSolution.compress(chars);
        System.out.println(result);
    }
}
