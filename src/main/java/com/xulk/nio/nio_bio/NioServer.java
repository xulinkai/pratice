package com.xulk.nio.nio_bio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: nio 是针对服务端而言的
 * 展示nio的基本原理
 * bio 阻塞的地方有 accpet  和 read  所以在nio当中应当释放掉这两处阻塞
 * @author:
 * @create: 2019-10-09 23:35
 **/
public class NioServer {

    static byte[] bytes = new byte[1024];
    static List<SocketChannel> list = new ArrayList<SocketChannel>();
    static ByteBuffer byteBuffer = ByteBuffer.allocate(512);

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 默认本机
        serverSocketChannel.bind(new InetSocketAddress(8080));
        //设置为非阻塞的
        serverSocketChannel.configureBlocking(false);
        while (true) {
            //阻塞的
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel == null) {
                Thread.sleep(1000);
                System.out.println("当前没有连接----");
                for (SocketChannel channel : list) {
                    int read = channel.read(byteBuffer);
                    if (read > 0) {
                        byteBuffer.flip();
                        System.out.println(byteBuffer.toString());
                    }
                }
            } else {//当前有了新的连接
                //读取数据的时候设置为非阻塞
                socketChannel.configureBlocking(false);
                //将当前socket连接 添加到集合当中  遍历的时候需要遍历所有，因为先前的连接会在后面重新发送数据
                list.add(socketChannel);
                for (SocketChannel channel : list) {
                    int k = channel.read(byteBuffer);
                    if (k > 0) {
                        byteBuffer.flip();
                        System.out.println("读取到的值：" + byteBuffer.toString());
                    }
                }

            }

        }

    }

}
