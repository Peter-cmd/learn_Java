package datagram.server;

import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;

public class Server {
    private static final int PORT = 9999;

    private static final int DATA_LINE = 4096;

    private byte[] buff_in = new byte[DATA_LINE];

    private DatagramPacket packet_in = new DatagramPacket(buff_in, buff_in.length);

    private DatagramPacket packet_out = null;

    private void service() throws Exception{
        try(DatagramSocket socket = new DatagramSocket(PORT)){
            String word = null;

            SocketAddress address = null;

            byte[] receiveData = null;

            System.out.println("服务器启动了");

            while (true){
                socket.receive(packet_in);
                buff_in = packet_in.getData();
                word = new String(buff_in, 0, buff_in.length).trim();
                System.out.println("客户端输入的是: " + word);
                address = packet_in.getSocketAddress();


                if ("exit".equals(word)){
                    receiveData = "服务器关闭了".getBytes();
                    packet_out = new DatagramPacket(receiveData, receiveData.length, address);
                    socket.send(packet_out);
                    break;
                }else{
                    receiveData = ("您输入的是:" + word).getBytes();
                    packet_out = new DatagramPacket(receiveData, receiveData.length, address);
                    socket.send(packet_out);

                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new Server().service();
    }
}
