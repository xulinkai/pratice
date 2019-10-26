package com.xulk.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @description:
 *                  准备：
 *                       开启FileChannel
 *                       从FileChannel中读取、写入数据
 *                       关闭FileChannel
 *
 * @author:
 * @create: 2019-08-28 22:38
 **/
public class FileChannelDemo {


    public static void main(String[] args) throws IOException {

        //1.创建一个RandomAccessFile（随机访问文件）对象通过RandomAccessFile对象的getChannel()方法。
        // mode r 可读  w 可写  rw 可读写+
        RandomAccessFile randomAccessFile = new RandomAccessFile("demo.txt","rw");
        FileChannel fileChannel = randomAccessFile.getChannel();

        //使用fileChannel的read方法读取数据
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int bytes = fileChannel.read(byteBuffer);

        //通过fileChannel的write方法写数据
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(1024);
        byteBuffer1.put("hello".getBytes());
        fileChannel.write(byteBuffer);

        //关闭fileChannel
        fileChannel.close();
    }


}
