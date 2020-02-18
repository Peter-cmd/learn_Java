package testhttp;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Request {
    //请求方法
    private String method;

    //请求地址
    private String url;

    //版本号
    private String version;

    //请求头
    private Map<String, String> headers = new HashMap();

    //请求参数
    private Map<String, String> parameters = new HashMap();

    private Request(){ }

    public static Request buildRequest(InputStream inputStream) {
        Request request = new Request();
        try {
            System.out.println("==========开始解析http请求============");
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(inputStream, "UTF-8"));
            String requestLine = input.readLine();
            request.parseRequestLine(requestLine);
            String header;
            System.out.println("请求头:");
            while ((header = input.readLine()) != null
                    && header.length() != 0){
                String[] parts = header.split(":");
                request.headers.put(parts[0].trim(), parts[1].trim());
                System.out.printf("%s: %s\n", parts[0].trim(), parts[1].trim());
                //如果是post方法提交,并且有Content-Length,表示请求数据中包含请求体
                //需要处理请求体
                if ("POST".equalsIgnoreCase(request.method)
                        && request.headers.containsKey("Content-length")){
                    int len = Integer.parseInt(request.headers.get("Content-length"));
                    char[] chars = new char[len];
                    input.read(chars,0,len);
                    request.parseParameters(new String(chars));
                }
            }
            System.out.println("请求参数:");
            for (Map.Entry<String, String> entry : request.parameters.entrySet()){
                System.out.printf("%s=%s\n", entry.getKey(), entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("处理请求数据错误", e);
        }

        return request;
    }

    //获取请求方法,请求路径和请求版本号
    private void parseRequestLine(String requestLine){
        if (requestLine == null || requestLine.length() == 0)
            return;
        String[] parts = requestLine.split(" ");
        method = parts[0];
        url = parts[1];
        int index = url.indexOf("?");
        if (index != -1){
            parseParameters(url.substring(index + 1));
            url = url.substring(0,index);
        }
        version = parts[2];
        System.out.printf("请求方法: %s, url: %s, 版本号: %s\n", method, url, version);
    }

    //处理请求参数
    private void parseParameters(String parameters){
        String[] parts = parameters.split("&");
        if (parts != null && parts.length != 0){
            for (String part : parts){
                String[] params = part.split("=");
                this.parameters.put(params[0], params[1]);
            }
        }
    }
}
