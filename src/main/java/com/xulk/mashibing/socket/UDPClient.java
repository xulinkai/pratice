package com.xulk.mashibing.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @description:
 * @author:
 * @create: 2019-09-23 23:37
 **/
public class UDPClient {

    public static void main(String[] args) throws IOException {
        byte[] bytes = (new String("hello")).getBytes();
        DatagramPacket datagramPacket =
                new DatagramPacket(bytes,bytes.length,new InetSocketAddress("127.0.0.1",8888));
        //客户端占据的端口
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        datagramSocket.send(datagramPacket);
        datagramSocket.close();


    }
}
