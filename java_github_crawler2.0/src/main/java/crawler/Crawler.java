package crawler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dao.Project;
import dao.ProjectDao;
import okhttp3.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class Crawler {

    //创建 OkHttpClient 对象
    private OkHttpClient okHttpClient = new OkHttpClient();

    //
    private Gson gson = new GsonBuilder().create();

    //url 黑名单
    private HashSet<String> urlBlackList = new HashSet<>();
    {
        urlBlackList.add("https://github.com/events");
        urlBlackList.add("https://github.community");
        urlBlackList.add("https://github.com/about");
        urlBlackList.add("https://github.com/pricing");
        urlBlackList.add("https://github.com/contact");
        urlBlackList.add("https://github.com/security");
        urlBlackList.add("https://github.com/site/privacy");
        urlBlackList.add("https://github.com/site/terms");
    }
    public static void main(String[] args) throws IOException {

        Crawler crawler = new Crawler();
        //通过 url 获取页面信息
        String html = crawler.getPage("https://github.com/akullpp/awesome-java/blob/master/README.md");
        //System.out.println(respBody);

        //使用 Jsoup 分析页面结构,把其中的 li 标签都获取到

        //把一个 html 字符串转化为 Document 对象
        //Document 是描述页面的树形结构
//        Document document = Jsoup.parse(respBody);
//        Elements elements =  document.getElementsByTag("li");

        //获取项目信息表
        List<Project> projects = crawler.parseProjectList(html);
        ProjectDao projectDao = new ProjectDao();
        for (int i = 0; i < projects.size() && i < 5; i++){
            Project project = projects.get(i);
            System.out.println("crawing" + project.getName() + " done!");
            String repoName = crawler.getRepoName(project.getUrl());
            String jsonString = crawler.getRepoInfo(repoName);
            crawler.parseRepoInfo(jsonString, project);
            System.out.println("crawing" + project.getName() + "...");
            projectDao.save(project);
        }

    }

    public String getPage(String url) throws IOException {

        //创建一个 Request 对象(进行一次网络访问操作)
        Request request = new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        //发送请求给服务器,接收响应信息 (Response) 对象
        Response response = call.execute();
        //判定响应是否成功
        if (!response.isSuccessful()){
            System.out.println("请求失败!");
            return null;
        }
        return response.body().string();
    }


    public List<Project> parseProjectList(String html){
        //项目信息表
        ArrayList<Project> result = new ArrayList<>();
        Document document = Jsoup.parse(html);
        //获取所有 li 标签
        Elements elements = document.getElementsByTag("li");

        //遍历 li 标签集合
        for (Element li : elements){
            //获取所有 a 标签
            Elements allLink = li.getElementsByTag("a");

            //排除无链接的内容
            if (allLink.size() == 0){
                continue;
            }

            //获取标签 a 的内容
            Element link = allLink.get(0);

            //排除非 GitHub 的 url
            if (!link.attr("href").startsWith("https://github.com/")){
                continue;
            }

            //排除黑名单中的 url
            if (urlBlackList.contains(link.attr("href"))){
                continue;
            }

            //将项目信息存入 Project 对象
            Project project = new Project();
            project.setName(link.text());
            project.setUrl(link.attr("href"));
            project.setDescription(li.text());
            //将项目对象插入项目表
            result.add(project);
        }
        return result;
    }

    //调用 Github API 获取指定仓库信息
    //repoName 形如: doov-io/doov
    public String getRepoInfo(String repoName) throws IOException {

        String userName = "peter-cmd";
        String passWord = "17060214123@Zmy";
        String credential = Credentials.basic(userName, passWord);
        //拼接 repoName, 形成完整的 url 路径(利用 GitHub 提供的 api)
        String url = "https://api.github.com/repos/" + repoName;
        //创建 Request 对象,完成一次请求操作
        Request request = new Request.Builder().url(url).header("Authorization",credential).build();
        //请求访问资源
        Call call = okHttpClient.newCall(request);
        //接收响应请求
        Response response = call.execute();
        //判定响应是否成功
        if (!response.isSuccessful()){
            System.out.println("访问 GitHub api 失败! url=" + url);
            return null;
        }
        //返回响应内容
        return response.body().string();
    }


    //解析仓库信息
    public void parseRepoInfo(String jsonString, Project project){
        //获取 HashMap 类型
        Type type = new TypeToken<HashMap<String, Object>>(){}.getType();
        HashMap<String, Object> hashMap = gson.fromJson(jsonString, type);

        Double starCount = (Double)hashMap.get("stargazers_count");
        project.setStartCount(starCount.intValue());

        Double forkCount = (Double)hashMap.get("forks_count");
        project.setForkCount(forkCount.intValue());

        Double openedIssueCount = (Double)hashMap.get("open_issues_count");
        project.setOpenIssueCount(openedIssueCount.intValue());

    }

    public String getRepoName(String url){
        int lastFirst = url.lastIndexOf("/");
        int lastSecond = url.lastIndexOf("/", lastFirst - 1);

        if (lastFirst == -1 || lastSecond == -1){
            System.out.println("当前 url 不是一个标准的项目 url! url:" + url);
            return null;
        }
        return url.substring(lastSecond + 1);
    }
}
