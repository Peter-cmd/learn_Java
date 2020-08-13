import java.util.Scanner;
import java.util.ArrayList;


public class T01{


    private static void reSortNumList(ArrayList<ArrayList<Integer>> list, int n){
        String[] results = new String[n];
        ArrayList<Integer> subList = null;


        for (int i = 0; i < n; i++){
            int c4 = 0;
            int c2 = 0;
            int c1 = 0;

            subList = list.get(i);
            int size = subList.size();
            for (int j = 0; j < size; j++){
                if (subList.get(j) % 4 == 0){
                    c4++;
                    continue;
                }

                if (subList.get(j) % 2 == 0){
                    c2++;
                    continue;
                }


                c1++;
            }
            if (c2 == 0){
                if (c4 >= c1 - 1){
                    results[i] = "Yes";
                    continue;
                }
            }else{
                if (c4 >= c1){
                    results[i] = "Yes";
                    continue;
                }
            }
            results[i] = "No";
        }
        for (int i = 0; i < n; i++){
            System.out.println(results[i]);
        }
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = 0;
        int length = 0;
        while (in.hasNext()){
            n = Integer.parseInt(in.next());
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int i = 0;
            while (i < n){
                length = Integer.parseInt(in.next());
                ArrayList<Integer> subList = new ArrayList<>();
                for (int j = 0; j < length; j++){
                    subList.add(Integer.parseInt(in.next()));
                }
                i++;
                list.add(subList);
            }
            reSortNumList(list, n);

        }
        in.close();
    }
}