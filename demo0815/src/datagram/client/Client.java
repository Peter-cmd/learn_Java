package datagram.client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    private static final int DEST_PORT = 9999;

    private static final String DEST_IP = "127.0.0.1";

    private static final int DATA_LINE = 4096;

    byte[] bufferIn = new byte[DATA_LINE];

    private DatagramPacket packetIn = new DatagramPacket(bufferIn, bufferIn.length);

    private DatagramPacket packetOut = null;

    private void service(){
        try(DatagramSocket socket = new DatagramSocket()){
            InetAddress ip = InetAddress.getByName(DEST_IP);
            packetOut = new DatagramPacket(new byte[0], 0, ip, DEST_PORT);

            Scanner in = new Scanner(System.in);
            String key = null;
            byte[] keyBuff = null;
            while (in.hasNext()){

                key = in.nextLine();

                if ("exit".equals(key)){
                    break;
                }

                keyBuff = key.getBytes();

                packetOut.setData(keyBuff);

                socket.send(packetOut);

                socket.receive(packetIn);

                System.out.println(new String(bufferIn, 0, packetIn.getLength()));

                System.out.println("请输入数据:");

            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("退出客户端!");
        }
    }

    public static void main(String[] args){

        new Client().service();
    }
}
