package testtcp;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient{
   // private static final String HOST = "127.0.0.1";
    //private static final String HOST = "localhost";
    private static final String HOST = "192.168.1.3";
    private static final int PORT = 9999;
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket(HOST, PORT);
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        OutputStream os = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
        PrintWriter pw = new PrintWriter(os , true);
       // pw.println("hello 我来了");
//        bw.write("hello 我来了\n");
//        bw.flush();
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String line = in.nextLine();  //已经去除换行符
            pw.println(line);
            String response = br.readLine();
            System.out.println("我已经接到了" + response);
        }
    }
}
