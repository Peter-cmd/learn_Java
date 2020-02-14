package job14.demo0001;

import java.util.ArrayList;
import java.util.List;

public class SubsetsSolution {
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> listsets = new ArrayList<>();
        listsets.add(new ArrayList<Integer>());
        for (Integer n : nums){
            int size = listsets.size();
            for (int i = 0; i < size; i++){
                List<Integer> list = new ArrayList<>(listsets.get(i));
                list.add(n);
                listsets.add(list);
            }
        }
        return listsets;
    }

    public static void main(String[] args){
        int[] nums = {1, 2, 3};
        List<List<Integer>> list1;
        SubsetsSolution ss = new SubsetsSolution();
        list1 = ss.subsets(nums);
        System.out.println(list1);
    }
}
