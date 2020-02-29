package testhttp;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.net.Socket;
import java.net.ServerSocket;
public class HttpServer {
    private static final int PORT = 9999;  //设置端口号
    private static final ExecutorService POOL = Executors.newCachedThreadPool();  //创建线程池
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        while(true) {
            Socket socket = serverSocket.accept();
            POOL.execute(new HttpTask(socket));
        }
    }
}
