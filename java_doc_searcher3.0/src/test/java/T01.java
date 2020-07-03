import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.io.*;
import java.util.List;

public class T01 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(
                        new File("E:\\Idea\\workspaces\\java12\\java_doc_searcher\\src\\main\\resources\\raw_data.txt")));
        String line = bufferedReader.readLine();
        long startTime = System.currentTimeMillis();
        List<Term> list = ToAnalysis.parse(line).getTerms();
        long endTime = System.currentTimeMillis();
        System.out.println("分词花费时间为: " + (endTime - startTime));
        for (Term term : list){
            System.out.println(term.getName());
        }
    }
}
