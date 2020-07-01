package parse;

import common.DocInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    //输入文件路径
    private final static String INPUT_PATH = "F:\\JAVA\\docs\\api";
    //输出文件路径
    private final static String OUT_PATH =
            "E:\\Idea\\workspaces\\java12\\java_doc_searcher\\src\\main\\resources\\raw_data.txt";

    public static void main(String[] args) throws IOException{
        //获取所有 INPUT_PATH 路径下所有 html 文件
        ArrayList<File> fileList = new ArrayList<>();
        enumAllFiles(INPUT_PATH, fileList);
        BufferedWriter output = new BufferedWriter(new FileWriter(new File(OUT_PATH)));

//        System.out.println(fileList);

        //将 fileList 中所有的文件信息解析
        for (File file : fileList){
            System.out.println("start convert " + file.getAbsolutePath() + "...");
            String line = convertFileInfo(file);
            output.write(line);
        }
        output.close();
    }

    //转换文件信息
    private static String convertFileInfo(File file) {
        // 1.转换文件标题
        String fileTitle = convertTitle(file);
        // 2.转换文件 url, 即将本地路径转换成线上路径
        String fileUrl = convertUrl(file);
        // 3.转换文件正文
        String fileContent = null;
        try {
            fileContent = convertContent(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileTitle + "\3" + fileUrl + "\3" + fileContent + "\n";
    }

    //转换文件的内容
    private static String convertContent(File file) throws IOException {
        //创建缓冲字符流,用以读取文件内容
        BufferedReader input = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();
        //用以去除 html 标签的标志
        boolean ifContent = false;
        String line;
        //按行读取文件内容
        while ((line = input.readLine()) != null){
            //将字符串转化为字符数组
            char[] temp = line.toCharArray();
            //遍历字符数组,去除 html 标签,换行和回车
            for (int i = 0; i < temp.length; i++){
                //若去除 html 标签标志位 true
                if (ifContent){
                    if (temp[i] == '<'){  //若找 html 标签开始字符
                        ifContent = false;
                        continue;
                    }
                    //去掉回车和换行
                    if (temp[i] == '\n' || temp[i] == '\r'){
                        temp[i] = ' ';
                    }
                    stringBuilder.append(temp[i]);
                }else{  //
                    if (temp[i] == '>')  //若找到正文,更新去除 html 标签标志为 true
                        ifContent = true;
                }
            }
        }
        input.close();
        return stringBuilder.toString();
    }

    //转换文件的 URL
    private static String convertUrl(File file) {
        //线上文档路径  https://docs.oracle.com/javase/8/docs/api/
        //本地文档路径  F:\JAVA\docs\api\java/util\AbstractCollection.html
        // 1.获取线上文档 URL 前缀
        String path1 = "https://docs.oracle.com/javase/8/docs/api";
        // 2.获取本地文档 URL 的后缀
        String path2 = file.getAbsolutePath().substring(INPUT_PATH.length());
        // 3.拼接并返回完整的 URL
        return path1 + path2;

    }

    //转换文章标题
    private static String convertTitle(File file) {
        //获取文件名
        String fileName = file.getName();
        //将文件名去掉 ".html" 后缀即为文件标题
        return fileName.substring(0,fileName.length() - ".html".length());
    }


    /**
     * 获取指定路径下的所有文件
     * @param inputPath  指定需要被获取所有子文件的路径
     * @param fileList  保存获取到的所有文件信息
     */
    private static void enumAllFiles(String inputPath, ArrayList<File> fileList) {
        //创建一个 file 文件类实例
        File root = new File(inputPath);
        //获取 file 中所有文件和目录
        File[] files = root.listFiles();

        //遍历 files, 依次获取 files 中每一个元素下的所有文件
        for (File file : files){
            //判断 file 是文件还是目录
            //若是目录,继续递归获取该目录下的所有文件
            if (file.isDirectory()){
                enumAllFiles(file.getAbsolutePath(), fileList);
            }else if (file.getAbsolutePath().endsWith(".html")){  //若是文件,存入 fileList
                fileList.add(file);
            }
        }
    }


}
