package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final int PORT = 9999;
    private static final String HOST = "127.0.0.1";

    public static void main(String[] args) throws IOException {
        Socket client = new Socket(HOST, PORT);
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
        Scanner in = new Scanner(System.in);

        String readLine = null;

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (in.hasNext()){
                    String line = in.nextLine();
                    pw.println(line);
                }
            }
        }).start();

        while ((readLine = br.readLine()) != null){
            System.out.println(readLine);
        }


    }
}
