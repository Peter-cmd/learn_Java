import common.DocInfo;
import index.Index;

import java.io.IOException;
import java.util.List;

public class T02 {
    public static void main(String[] args) throws IOException {

        Index index = new Index();
        System.out.println(T02.class.getClassLoader().getResource("raw_data.txt"));
        index.build((T02.class.getClassLoader().getResource("raw_data.txt") + "").substring(6));
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
