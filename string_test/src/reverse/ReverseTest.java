package reverse;

public class ReverseTest {
    public static String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = strs.length - 1; i >= 0; i--) {
            if ("".equals(strs[i])) continue;
            result.append(strs[i]);
            result.append(" ");

        }
        return result.toString().trim();
    }

    public static void main(String[] args){
            String input = "   hello   world!   ";
            String result = reverseWords(input);
        System.out.println(result);
    }
}
