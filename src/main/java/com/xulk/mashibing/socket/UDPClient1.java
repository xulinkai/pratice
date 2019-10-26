package com.xulk.mashibing.socket;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @description:
 * @author:
 * @create: 2019-09-23 23:37
 **/
public class UDPClient1 {

    public static void main(String[] args) throws IOException {

        long n = 1000L;
        ByteOutputStream byteOutputStream = new ByteOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteOutputStream);
        dataOutputStream.writeLong(n);
        byte[] bytes = byteOutputStream.getBytes();
        DatagramPacket datagramPacket =
                new DatagramPacket(bytes,bytes.length,new InetSocketAddress("127.0.0.1",8888));
        //客户端占据的端口
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        datagramSocket.send(datagramPacket);
        datagramSocket.close();


    }
}
