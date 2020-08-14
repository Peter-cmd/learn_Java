package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final int PORT = 9999;

    private static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);

        while (true){
            Socket client = server.accept();
            EXECUTOR.execute(new Task(client));
        }
    }

    private static class Task implements Runnable{
        private Socket client;

        public Task (Socket client){
            this.client = client;
        }
        @Override
        public void run() {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
                String readLine = null;
                while ((readLine = br.readLine()) !=  null){
                    System.out.println(readLine);
                    pw.println("真的吗?太厉害了!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
