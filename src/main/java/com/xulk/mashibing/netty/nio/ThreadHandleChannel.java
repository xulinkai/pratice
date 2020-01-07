package com.xulk.mashibing.netty.nio;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/**
 * @description:
 * @author:
 * @create: 2020-01-02 22:29
 **/
public class ThreadHandleChannel implements Runnable {

    private SelectionKey key;

    public ThreadHandleChannel(SelectionKey selectionKey) {
        this.key = selectionKey;
    }

    @Override
    public void run() {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            int size = 0;
            while ((size = socketChannel.read(buffer)) > 0) {
                buffer.flip();
                baos.write(buffer.array(), 0, size);
                buffer.clear();
            }
            baos.close();
            byte[] content = baos.toByteArray();
            ByteBuffer writeBuffer  = ByteBuffer.allocate(content.length);
            writeBuffer.put(content);
            writeBuffer.flip();
            socketChannel.write(writeBuffer);
            if(size==-1){
                socketChannel.close();
            }else{
                //读完之后还要继续关心读事件
                key.interestOps(key.interestOps()|SelectionKey.OP_READ);
                //事件处理完之后 及时唤醒大管家
                key.selector().wakeup();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
