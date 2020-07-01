import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.util.List;

public class T01 {
    public static void main(String[] args){
        String line = "你好啊,圣诞先生";
        List<Term> list = ToAnalysis.parse(line).getTerms();
        for (Term term : list){
            System.out.println(term.getName());
        }
    }
}
