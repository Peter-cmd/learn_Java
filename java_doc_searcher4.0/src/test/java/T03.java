import searcher.Result;
import searcher.Searcher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class T03 {
    public static void main(String[] args) throws IOException {
        Searcher s = new Searcher();
        List<Result> resultList = s.search("arraylist");
        for (Result result : resultList){
            System.out.println("===========================================");
            System.out.println(result.getTitle());
            System.out.println(result.getClickUrl());
            System.out.println(result.getDescribe());
        }

    }

}
