package testhttp;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
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
    private Map<String, String> headers = new HashMap<>();
    //请求参数
    private Map<String, String> parameters = new HashMap<>();

    private Request(){}

    //处理请求
    public static Request buildRequest(InputStream inputStream) {
        Request request = new Request();  //创建请求
        System.out.println("=====================开始解析http协议====================");
        try {
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(inputStream, "UTF-8"));
            String requestLine = input.readLine();  //读取第一行数据(包含请求方法,请求地址,版本号)
            request.parseRequestLine(requestLine);  //解析第一行数据
            //处理请求头
            String header;
            //若存在请求头
            System.out.println("请求头:");
            while ((header = input.readLine()) != null
                    && header.length() != 0){
                String[] parts = header.split(":");  //以 : 为分割符分割请求头的键和值
                request.headers.put(parts[0], parts[1]);  //保存请求头
                System.out.printf("%s: %s\n", parts[0].trim(), parts[1].trim());  //打印请求头
            }

            //处理请求体
            if ("POST".equalsIgnoreCase(request.method)
                    && request.headers.containsKey("Content-Length")){
                int len = Integer.parseInt(request.headers.get("Content-Length").trim());  //获取请求体的大小
                char[] chars = new char[len];
                input.read(chars, 0, len);
                request.parseParameters(new String(chars));
            }

            //遍历 parameters 打印参数信息
            System.out.println("请求参数:");
            for (Map.Entry<String, String> entry : request.parameters.entrySet()){
                System.out.printf("%s: %s\n", entry.getKey(), entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("处理请求数据错误", e);
        }
        return request;
    }

    //处理请求数据
    private void parseRequestLine(String requestLine) {
        //若获取的数据为空,直接返回
        if(requestLine == null || requestLine.length() == 0){
            return;
        }
        //处理数据
        String[] parts = requestLine.split(" ");
        method = parts[0];  //保存请求方法
        url = parts[1];  //保存请求地址
        //若请求路径中有参数,需要处理参数
        int index = url.indexOf("?");
        if (index != -1){
            parseParameters(url.substring(index + 1));  //处理参数
            url = url.substring(0, index);  //切割获取url
        }
        version = parts[2];  //保存版本号
        System.out.printf("请求方法: %s, url: %s, 版本号: %s\n", method, url, version);

    }

    //处理请求参数
    private void parseParameters(String substring) {
        String[] parts = substring.split("&");  //切割获取一对参数的参数名和参数值
        if (parts != null && parts.length != 0){  //若有参数,保存参数
            for (String part : parts){
                String[] params = part.split("=");  //以等号为界分割参数的键和值
                parameters.put(params[0], params[1]);  //保存参数
            }

        }
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getVersion() {
        return version;
    }

    /**
     * 根据请求头中的key获取value
     * @param key
     * @return
     */
    public String getHeaders(String key) {
        return headers.get(key);
    }

    /**
     * 根据参数中的key获取value
     * @param key
     * @return
     */
    public String getParameters(String key) {
        return parameters.get(key);
    }
}
