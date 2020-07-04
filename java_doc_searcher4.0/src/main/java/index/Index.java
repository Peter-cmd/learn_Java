package index;

import common.DocInfo;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Index {

    //权重类
    public static class Weight{
        //保存分词
        public String word;
        //保存该分词出现的文档 id
        public int docId;
        //保存该分词的权重
        public int weight;

        public Weight(String word, int docId, int weight) {
            this.word = word;
            this.docId = docId;
            this.weight = weight;
        }
    }

    class MyTime{
        public long buildForward;
        public long buildInverted;
    }

    //构建正排索引
    private ArrayList<DocInfo> forwardIndex = new ArrayList<>();

    //构建倒排索引
    private HashMap<String, ArrayList<Weight>> invertedIndex = new HashMap<>();

    //通过文档 id 获取文档
    public DocInfo getDocInfo(int docId){
        return forwardIndex.get(docId);
    }

    //通过关键字获取 word 的权重索引
    public ArrayList<Weight> getInverted(String word){
        return invertedIndex.get(word);
    }

    /**
     * 构建文件标题和内容的正排和倒排索引
     * @param filePath  需要构建索引的文件路径
     * @throws IOException
     */
    public void build(String filePath) throws IOException {
        MyTime time = new MyTime();
        //创建缓冲字符流从 filePath 文件中读取数据
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filePath)));
        String line = null;
        //按行读取文件内容
        while ((line = bufferedReader.readLine()) != null){
            //根据读取内容构建正排索引
            long time1 = System.currentTimeMillis();
            DocInfo docInfo = buildForward(line);
            forwardIndex.add(docInfo);
            System.out.println("build " + docInfo.getTitle() + "done...");
            //根据正排索引结果构建倒排索引
            long time2 = System.currentTimeMillis();
            buildInverted(docInfo);
            long time3 = System.currentTimeMillis();
            time.buildForward += time2 - time1;
            time.buildInverted += time3 - time2;
        }
        bufferedReader.close();
        System.out.println("构建正排索引耗时: " + time.buildForward + "ms\n" +
        "构建倒排索引耗时: " + time.buildInverted + "ms");
    }

    //构建倒排索引
    private void buildInverted(DocInfo docInfo) {
        //分词数量类
        class WordCount{
            public int inTitle;
            public int inContent;

            public WordCount(int inTitle, int inContent){
                this.inTitle = inTitle;
                this.inContent = inContent;
            }
        }
        //创建保存关键字在 title 和 content 中出现次数的 map
        HashMap<String, WordCount> wordCountMap = new HashMap<>();
        //根据文档 title 进行分词;
        List<Term> titleTerms = ToAnalysis.parse(docInfo.getTitle()).getTerms();
        //统计并记录分词结果;
        for (Term term : titleTerms){
            //通过 term 获取关键字在 map 中的信息
            WordCount wordCount = wordCountMap.get(term.getName());
            //若 term 指定的关键字尚未保存
            if (wordCount == null){
                //将该关键字的基础信息添加入 map
                wordCount = new WordCount(1, 0);
                wordCountMap.put(term.getName(), wordCount);
            }else{  //若 map 已保存了该关键字的信息
                wordCount.inTitle++;  //该关键字在 title 中出现的次数加 1
            }
        }
        //根据文档 content 进行分词;
        List<Term> contentTerms = ToAnalysis.parse(docInfo.getContent()).getTerms();
        //统计并记录分词结果;
        for  (Term term : contentTerms){
            WordCount wordCount = wordCountMap.get(term.getName());
            if (wordCount == null){
                wordCount = new WordCount(0, 1);
                wordCountMap.put(term.getName(), wordCount);
            }else{
                wordCount.inContent++;
            }
        }

        //根据上述步骤的统计结果,计算每一个分词的权重并保存;
        for (HashMap.Entry<String, WordCount> entry : wordCountMap.entrySet()){
            String word = entry.getKey();
            //计算分词 word 在本文档中的权重
            int weight = entry.getValue().inTitle * 10 + entry.getValue().inContent;
            //若倒排索引中未存在该分词
            if (!invertedIndex.containsKey(word)){
                //创建并添加一个分词权重列表
                invertedIndex.put(word, new ArrayList<>());
            }
            //将该分词的权重加入权重列表
            invertedIndex.get(word).add(new Weight(word, docInfo.getDocId(), weight));
        }
    }

    //构建正排索引
    private DocInfo buildForward(String line) {
        //以 "\3" 分割 line,分别获取文件的 title, url 和 content;
        String[] subs = line.split("\3");
        //通过 subs 的长度,判断文档是否合格
        //如果 subs 的长度不等于 3, 即文档合格
        if (subs.length != 3){
            //若文档不合格,打印文档信息
            System.out.println("文件格式有问题:" + line);
            return null;
        }
        //若文档合格,保存并返回文档信息
        DocInfo docInfo = new DocInfo();
        //文档的 docId 即为当前 forwardIndex 的大小
        docInfo.setDocId(forwardIndex.size());
        //设置文档的 title, url 和 content
        docInfo.setTitle(subs[0]);
        docInfo.setUrl(subs[1]);
        docInfo.setContent(subs[2]);
        return docInfo;
    }


}
