package testhttp;

import java.io.*;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class HttpTask implements Runnable {
    private Request request;  //请求引用
    private Response response;  //响应引用
    private static final String SESSION_KEY = "SESSIONID";
    private static ConcurrentHashMap<String, String> SESSIONS = new ConcurrentHashMap<>();
    public HttpTask(Socket socket) {

        try {
            request = Request.buildRequest(socket.getInputStream());  //创建并获取请求对象
            response = Response.buildReponse(socket.getOutputStream());  //创建并获取响应对象
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("客户端连接IO流出错", e);
        }
    }

    @Override
    public void run() {


            try {
                //若用户请求的是根路径
                if ("/".equals(request.getUrl())){
                    response.build200();
                    response.println("服务器首页");
                    return;
                }

                //url以 / 开始
                InputStream is = this.getClass().getClassLoader()
                        .getResourceAsStream("." + request.getUrl());
                if (is != null){
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(is, "UTF-8"));
                    String content;
                    while ((content = br.readLine()) != null){
                        response.println(content);
                    }
                    response.build200();
                }else if("/login".equalsIgnoreCase(request.getUrl())) {
                    if (!"post".equalsIgnoreCase(request.getMethod())) {
                        response.build405();
                        response.println("不支持的请求方法" + request.getMethod());
                    } else {  //校验用户密码
                        response.build200();
                        response.println("请求的数据:" + "username="
                                + request.getParameters("username")
                                + " password=" + request.getParameters("password"));
                        //Session 将用户信息保存在服务器,并返回给客户端
                        String sessionId = UUID.randomUUID().toString();
                        SESSIONS.put(sessionId, "用户名:" + request.getParameters("username")
                                + " 密码:  " + request.getParameters("password"));
                       // response.addHeader("Set-Cookie", sessionId);
                        response.addHeader("Set-Cookie", SESSION_KEY + "=" + sessionId);
                    }
                }else if ("/sensitive".equals(request.getUrl())){  //敏感的url,未登陆时不能访问
                    String content = "<p>该用户没有登录</p>";
                    String sessionInfo = request.getHeaders("Cookie");
                    if (sessionInfo != null && sessionInfo.trim().length() != 0) {
                        String[] cookiesInfo = sessionInfo.trim().split(";");
                        if (cookiesInfo.length != 0) {
                            for (String cookieInfo : cookiesInfo) {
                                String[] cookie = cookieInfo.trim().split("=");
                                if (SESSION_KEY.equals(cookie[0])){
                                    String userInfo = SESSIONS.get(cookie[1]);
                                    if (userInfo != null){
                                        content = "获取到的客户信息为:" + userInfo;
                                        System.out.println("=========" + content);
                                    }
                                }
                            }
                        }
                    }
                    response.build200();
                    response.println(content);
                }
                else{  //服务器不提供该服务
                    response.build404();
                    response.println("找不到资源");
                }

            } catch (Exception e) {  //服务器出错
                e.printStackTrace();
                response.build500();
                response.println("服务器出错!");
            } finally {
            response.flush();
        }
    }
}
