package testtcp;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpServer {
    //线程池
    private static final ExecutorService EXE = Executors.newCachedThreadPool();
    private static final int PORT = 9999;
    public static void main(String[] args) throws IOException {
        //启动TCP服务
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true){
            final Socket socket = serverSocket.accept();
            EXE.submit(new Runnable(){
                @Override
                public void run() {
                    try {
                        InputStream is = socket.getInputStream();
                        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                        OutputStream os = socket.getOutputStream();
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                        PrintWriter pw = new PrintWriter(bw, true);
                        String line;
                        //阻塞等待客户端传过来的数据
                        //readLine读取换行符之前的数据
                        while ((line = br.readLine()) != null){
                            System.out.println("服务端接收到消息:" + line);
                            pw.println("我已经接收到消息:" + line);
        //                bw.write("我已经结束到消息:" + line + "了");
        //                //需要刷新一下缓冲区,这时才会将数据发送到对端
        //                bw.flush();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
