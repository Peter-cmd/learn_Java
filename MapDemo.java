package test1128;
import java.util.HashMap;
import java.util.Map;
public class MapDemo {
    public static void main(String[] args){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"Java");
        map.put(2,"hello");
        map.put(3,"c语言");
        map.put(2,"Hello");
        map.put(4,"World");
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));
        System.out.println(map.get(4));
        System.out.println(map.get(5));
        System.out.println(map.containsKey(3));
        System.out.println(map.containsValue("c语言"));
        System.out.println(map.remove(3));
        System.out.println(map.containsKey(3));
        System.out.println(map.containsValue("c语言"));
        System.out.println(map.keySet());
        System.out.println(map.values());

        for (Integer key : map.keySet()){
            System.out.println(key);
        }

        for (String value : map.values()){
            System.out.println(value);
        }

        for (Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

    }
}
