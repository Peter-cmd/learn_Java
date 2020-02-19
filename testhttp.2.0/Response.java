package testhttp;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Response {
    private PrintWriter writer;

    //版本号
    private String version = "HTTP/1.1";
    //状态码
    private int status;
    //状态码描述
    private String message;
    //响应头
    private Map<String, String> headers = new HashMap<>();
    //响应体
    private StringBuilder body = new StringBuilder();

    public Response() {}

    public static Response buildResponse(OutputStream outputStream) {
        Response response = new Response();
        response.writer = new PrintWriter(outputStream, true);
        return response;
    }

    public void addHeader(String key, String value){
        this.headers.put(key, value);
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void println(String line){
        body.append(line + "\n");
    }

    public void flush(){
        //打印响应行
        writer.println(version + " " + status + " " + message);
        //打印响应头
        writer.println("Content-Type: text/html;  charset=UTF-8");
        if (body.length() != 0){
            //String.getBytes()方法可以将一个字符串转换为字节数组
            writer.println("Context-length:" + body.toString().getBytes().length);
        }
        for (Map.Entry<String, String> entry : headers.entrySet()){
            writer.println(entry.getKey() + ": " + entry.getValue());
        }
        //打印空行
        writer.println();
        //打印响应体
        if (body.length() != 0){
            writer.println(body);
        }
        //刷新输出流:1.在初始化PrintWiter时,将第二个参数设为true; 2.调用flush()方法
        //writer.flush();

    }

    /**
     * 构建200正确响应
     */
    public void build200(){
        status = 200;
        message = "OK";
    }

    /**
     * 构建404找不到资源
     */
    public void build404(){
        status = 404;
        message = "Not Found";
    }

    /**
     * 构建307重定向
     */
    public void build307(){
        status = 307;
        message = "Send Redirect";
    }

    /**
     *构建405不支持的服务
     */
    public void build405(){
        status = 405;
        message = "Mehtod Not Allowed";
    }

    /**
     * 构建500服务器错误
     */
    public void build500(){
        status = 500;
        message = "Internal Server Error";
    }
}
