package preK;

import java.util.*;

public class TopkStrings {


    public String[][] topKstrings1(String[] strings, int k) {
        // write code here

        Map<String, Integer> map = new HashMap<>();

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>();

        for (String string : strings) {
            if (!map.containsKey(string)) {
                map.put(string, 1);
            }else {
                map.put(string, (map.get(string) + 1));
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry);
        }

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue() - o1.getValue();
            }
        });
        
        String[][] result = new String[k][2];
        for (int i = 0; i < k; i++){
            result[i][0] = list.get(i).getKey();
            result[i][1] = list.get(i).getValue() + "";
        }
        return result;
    }

}
