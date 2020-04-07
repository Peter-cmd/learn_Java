package demo003;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private <S> S getString(Class<S> classz) throws IllegalAccessException, InstantiationException {
        return classz.newInstance();
    };
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Main main = new Main();
        HashMap<Integer, String> map = main.getString(HashMap.class);
        map.put(1, "年后");
        System.out.println(map.get(1));
    }
}
