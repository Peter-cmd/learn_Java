package testhttp;

import java.io.IOException;
import java.net.Socket;

public class HttpTask implements Runnable{

    private Request request;
    private Response response;
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
        response.setStatus(200);
        response.setMessage("OK");
        response.println("正确响应了用户信息.");
        response.flush();
    }
}
