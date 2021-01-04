package ordered.treemap;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args){
        TreeMap<String, String> map = new TreeMap<>();
        map.put("123", "123");
        map.put("234", "234");
        map.put("abc", "abc");
        map.put("bcd", "bcd");
        for (Map.Entry<String, String> entry : map.entrySet()){
            System.out.println(entry.getValue());
        }

    }
}
