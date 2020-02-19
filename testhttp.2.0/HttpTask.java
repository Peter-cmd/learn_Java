package testhttp;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class HttpTask implements Runnable{

    private Request request;
    private Response response;
    //服务器端保存 seesion 的数据结构(线程安全的Map);还可以保存在其他地方, 如:redis中间件
    private static ConcurrentHashMap<String, String> SESSIONS = new ConcurrentHashMap<>();
    public HttpTask(Socket socket) {
        try {
            request = Request.buildRequest(socket.getInputStream());
            response = Response.buildResponse(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("客户端连接IO流出错", e);
        }
    }

    @Override
    public void run() {
        try {

            //若请求的url为根路径
            if ("/".equals(request.getUrl())){
                response.build200();
                response.println("<h2> 服务器首页 <h2>");
                return;
            }
            //怎么读取文件? 1.绝对路径 2.相对路径
            //1.html所在的文件的webapp文件需要设置为resouses资源文件夹
            //将webapp中所有的文件复制到编译的输出文件夹
            //2.通过ClassLoader.getResourceAsStream()获取文件的输入流(相对路径)
            InputStream is =
                    this.getClass().getClassLoader()
                            .getResourceAsStream("." + request.getUrl());
            //http请求行 url 以/开始
            if (is != null) {
                BufferedReader br =
                        new BufferedReader(new InputStreamReader(is, "UTF-8"));
                String content;
                while ((content = br.readLine()) != null) {
                    response.println(content);
                }

                response.build200();
            }else if ("/login".equals(request.getUrl())){
                //只接受 post 请求方法,否则返回405
                if (!"post".equalsIgnoreCase(request.getMethod())){
                    response.build405();
                    response.println("不支持的请求方法:" + request.getMethod());

                }else{  //校验用户名和密码
                    response.build200();
                    response.println("请求的数据:" +
                    "username= " + request.getParameter("username") +
                    ", password= " + request.getParameter("password"));
                    //Session 将用户信息保存到服务器,并返回给客户端
                    String sessionId = UUID.randomUUID().toString();
                    SESSIONS.put(sessionId,
                            request.getParameter(request.getParameter("username")
                            + "," + request.getParameter(request.getParameter("password"))));

                }
            }else if ("/sensitive".equals(request.getUrl())){  //敏感的url,未登录时,不能访问

            }
            else{  //以上路径都找不到说明,说明我们的服务器不提供该服务,返回404
                response.build404();
                response.println("找不到资源!");

            }
        } catch (Exception e) {  //捕获所有异常,说明服务器出错,返回500
            e.printStackTrace();
            response.build500();
            response.println("服务器出错!");
        }finally{  //无论服务器响应与否,都要刷新
            //返回数给客户端
            response.flush();
        }

    }
}
