package searcher;

import common.DocInfo;
import index.Index;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Searcher {

    private Index index = new Index();

    public Searcher() throws IOException {
        index.build("E:\\Idea\\workspaces\\java12\\java_doc_searcher\\src\\main\\resources\\raw_data.txt");
    }

    public List<Result> search(String query){
        // 1.[分词] 对用户的输入 query 进行分词操作;
        List<Term> termsList = ToAnalysis.parse(query).getTerms();
        // 2.[触发] 根据 1 中的分词结果到倒排索引中查找对应分词的权重列表,
        //   即可获得某一分词在 docId 指定文档中所占的权重(weight)和 title;
        List<Index.Weight> allTokenResult = new ArrayList<>();
        for (Term term : termsList){
            String word =  term.getName();
            List<Index.Weight> invertedList = index.getInverted(word);
            if (invertedList == null){
                continue;
            }
            allTokenResult.addAll(invertedList);
        }
        // 3.[排序] 根据权重,将权重列表按降序排序;
        allTokenResult.sort(new Comparator<Index.Weight>(){
            @Override
            public int compare(Index.Weight o1, Index.Weight o2) {
                return o2.weight - o1.weight;
            }
        });
        // 4.[包装结果] 根据经过排序的权重列表进行结果的封装,将结果封装成
        // Result 对象列表;
        List<Result> resultList = new ArrayList<>();
        for (Index.Weight weight : allTokenResult){
            DocInfo docInfo = index.getDocInfo(weight.docId);
            Result result = new Result();
            result.setTitle(docInfo.getTitle());
            result.setShowUrl(docInfo.getUrl());
            result.setClickUrl(docInfo.getUrl());
            result.setDescribe(genDesc(docInfo.getContent(), weight.word));
            resultList.add(result);
        }
        return resultList;
    }

    private String genDesc(String content, String word) {
        //取关键词前 60 个和后 160 个作为 Result 对象的 desc;
        int keyPosition = content.toLowerCase().indexOf(word);
        if (keyPosition == -1){
            return "";
        }
        //若关键词所处位置小于 60,则从文档内容第一个字符开始;
        int descBegin = (keyPosition < 60) ? 0 : keyPosition - 60;
        //若关键词所处位置到文档内容结尾小于 160,则到文档内容结尾为止;
        if (descBegin + 160 > content.length()){
            return content.substring(descBegin);
        }
        return content.substring(descBegin, descBegin + 160) + "...";
    }
}
