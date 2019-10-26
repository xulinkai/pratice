package com.xulk.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * @description:
 * DataGramChannel，类似于java 网络编程的DatagramSocket类； 使用UDP进行网络传输， UDP是无连接，面向数据报文段的协议。
 *
 * @author:
 * @create: 2019-08-28 23:22
 **/
public class DatagramChannel_server {


    public static void main(String[] args) throws IOException {
        DatagramChannel dc= DatagramChannel.open();
        dc.bind(new InetSocketAddress(InetAddress.getByName("LAPTOP-D9966H06"),8888));
        //创建读数据/写数据缓冲区对象来读取客户端数据或向客户端发送数据
        //读取客户端发送的数据
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        //从通道中读取数据到缓冲区
        dc.receive(buffer);
        StringBuffer sb=new StringBuffer();
        buffer.flip();
        while(buffer.hasRemaining()){
            sb.append((char)buffer.get());
        }
        System.out.println(sb.toString());

        ByteBuffer buffer2=ByteBuffer.allocate(1024);
        //向客户端发送数据
        buffer2.put("data has been received.".getBytes());
        buffer2.flip();
        dc.send(buffer2,new InetSocketAddress(InetAddress.getByName("LAPTOP-D9966H06"),9999));

        dc.close();

    }
}
