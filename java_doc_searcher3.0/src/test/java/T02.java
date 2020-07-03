import common.DocInfo;
import index.Index;

import java.io.IOException;
import java.util.List;

public class T02 {
    public static void main(String[] args) throws IOException {

        Index index = new Index();
        index.build("E:\\Idea\\workspaces\\java12\\java_doc_searcher\\src\\main\\resources\\raw_data.txt");
        List<Index.Weight> invertedIndex = index.getInverted("arraylist");
        for (Index.Weight weight : invertedIndex){
            System.out.println("=============");
            System.out.println("文档id: " + weight.docId);
            System.out.println("分词为: " + weight.word);
            System.out.println("分词在文档中的权重为: " + weight.weight);
            DocInfo docInfo = index.getDocInfo(weight.docId);
            System.out.println("分词所在文档为: " + docInfo.getTitle());
        }
    }
}
