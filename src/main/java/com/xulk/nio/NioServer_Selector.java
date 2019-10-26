package com.xulk.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @description:
 *
 *              1、创建选择器，
 *              2、将通道注册到选择器上，（通道必须配置为非阻塞模式）
 *              3、监听事件
 *              4、获取到达的事件
 *              5、事件循环（一次select不能处理完所有的事件，并且服务端有可能需要一直监听事件，
 *                           因此服务端处理事件的代码一般会放在一个死循环内）
 *
 * @author:
 * @create: 2019-08-29 22:09
 **/
public class NioServer_Selector {

    private static String readDataFromSocketChannel(SocketChannel sChannel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        StringBuilder data = new StringBuilder();

        while (true) {
            buffer.clear();
            int r = sChannel.read(buffer);
            if (r == -1) {
                break;
            }
            buffer.flip();
            int limit = buffer.limit();
            char[] dst = new char[limit];
            for (int i = 0; i < limit; i++) {
                dst[i] = (char) buffer.get(i);
            }
            data.append(dst);
            buffer.clear();
        }
        return data.toString();
    }

    public static void main(String[] args) throws IOException {
        //1. 创建选择器
        Selector selector = Selector.open();
        //2.将通道注册到选择器上
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        //通道必须配置为非阻塞模式，否则使用选择器就没有任何意义了
        ssChannel.configureBlocking(false);
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        ServerSocket ss=ssChannel.socket();
        ss.bind(new InetSocketAddress("127.0.0.1",8888));

        while (true){
            //3. 监听事件
            selector.select();
            //4. 获取到达的事件
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = keys.iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                if (key.isAcceptable()) {
                    ServerSocketChannel ssChannel1 = (ServerSocketChannel) key.channel();

                    // 服务器会为每个新连接创建一个 SocketChannel
                    SocketChannel sChannel = ssChannel1.accept();
                    sChannel.configureBlocking(false);

                    // 这个新连接主要用于从客户端读取数据
                    sChannel.register(selector, SelectionKey.OP_READ);

                } else if (key.isReadable()) {
                    SocketChannel sChannel = (SocketChannel) key.channel();
                    System.out.println(readDataFromSocketChannel(sChannel));
                    sChannel.close();
                }
                keyIterator.remove();
            }
        }
    }




}
