package demo1003;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
public class Main{
    private static Map<String, Integer> map = new HashMap<>();
    static {
        map.put("0", 0);
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        map.put("9", 9);
        map.put("A", 10);
        map.put("B", 11);
        map.put("C", 12);
        map.put("D", 13);
        map.put("E", 14);
        map.put("F", 15);
    }
    private  static void convert(String input){
        int length = input.length();
        int result = 0;
        for (int i = length - 1; i >= 0; i--){
            result += map.get(input.charAt(i) + "") * Math.pow(16, (length - 1 - i));
        }
        System.out.println(result);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String input = in.next();
            convert(input);
        }
    }
}
