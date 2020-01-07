package com.xulk.mashibing.netty.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @description:  aio模型  单线程
 * @author:
 * @create: 2020-01-02 22:46
 **/
public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {
        final AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open()
                .bind(new InetSocketAddress(8888));
        //aio当前这个方法不是阻塞的  所以尾部需要加上while(true)循环，否则的话，程序直接结束了
        //因为不是阻塞的，所以设置了一个钩子函数，
        //bio 的accept方法是直接在那里傻等，直到有人连上来，

        serverChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {

            @Override
            public void completed(AsynchronousSocketChannel client, Object attachment) {
                try {
                    serverChannel.accept(null, this);
                    System.out.println(client.getRemoteAddress());
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    //当前这个read也是异步的，同样有一个钩子函数，调用完了 调用钩子函数
                    client.read(byteBuffer, byteBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                        @Override
                        public void completed(Integer result, ByteBuffer attachment) {
                            attachment.flip();
                            System.out.println(new String(attachment.array(), 0, result));
                            client.write(ByteBuffer.wrap("HelloClient".getBytes()));
                        }

                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {

                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void failed(Throwable exc, Object attachment) {

            }
        });

        while(true){
            Thread.sleep(1000);
        }


    }
}
