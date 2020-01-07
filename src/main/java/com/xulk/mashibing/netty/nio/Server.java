package com.xulk.mashibing.netty.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @description:  一个线程处理多个连接
 *                nio的单线程模型
 *                客户端还是都一样，连接一下服务端
 * @author:
 * @create: 2020-01-02 21:37
 **/
public class Server {


    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress("127.0.0.1", 8888));
        //设置成非阻塞
        ssc.configureBlocking(false);

        System.out.println("server started listening on : " + ssc.getLocalAddress());
        //selector类似于一个大管家
        Selector selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            selector.select();//阻塞方法
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                handleKey(selectionKey);
            }

        }

    }

    static void handleKey(SelectionKey key) throws IOException {
        if (key.isAcceptable()) {
            try {
                ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                SocketChannel socketChannel = serverSocketChannel.accept();
                socketChannel.configureBlocking(false);

                /*List<String> clients = new ArrayList<>();
                String hostIP = ((InetSocketAddress) socketChannel.getRemoteAddress()).getHostString();
                System.out.println("client "+hostIP+" trying to connect");
                for (int i = 0; i < clients.size(); i++) {
                    String clientHostIp = clients.get(i).clientAdress.getHostString();
                    if(hostIP.equals(clientHostIp)){
                        System.out.println(" this client has already connected! is he alive "+clients.get(i).live);
                        socketChannel.close();
                        return;
                    }
                }*/
                //注册关心的事件
                socketChannel.register(key.selector(), SelectionKey.OP_READ);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (key.isReadable()) {
            SocketChannel socketChannel = null;
            try {
                socketChannel = (SocketChannel) key.channel();
                /**
                 * byteBuffer 只有一个指针，读、写都用这个指针，比较难用
                 * 在netty封装的byteBuf里面， 有两个指针，一个读指针一个写指针
                */
                ByteBuffer buffer = ByteBuffer.allocate(512);
                buffer.clear();
                int len = socketChannel.read(buffer);
                if (len != -1) {
                    System.out.println(new String(buffer.array(), 0, len));
                }
                ByteBuffer bufferToWrite = ByteBuffer.wrap("HelloClient".getBytes());
                socketChannel.write(bufferToWrite);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if (socketChannel != null) {
                    socketChannel.close();
                }
            }
        }

    }
}
