package com.xulk.mashibing.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:   nio的多线程模型
 * @author:
 * @create: 2020-01-02 22:14
 **/
public class PoolServer {

    ExecutorService pool = Executors.newFixedThreadPool(50);
    private Selector selector;

    public void initServer(int port) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        this.selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务端启动成功");
    }

    public void listen() throws IOException {
        while(true){
            selector.select();
            Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(this.selector, SelectionKey.OP_READ);
                }else if(selectionKey.isReadable()){
                    //相当于去除掉 read事件  remove类似
                    selectionKey.interestOps(selectionKey.interestOps()&(~SelectionKey.OP_READ));
                    pool.execute(new ThreadHandleChannel(selectionKey));
                }
            }

        }

    }

    public static void main(String[] args) throws IOException {
        PoolServer poolServer = new PoolServer();
        poolServer.initServer(8888);
        poolServer.listen();
    }
}
