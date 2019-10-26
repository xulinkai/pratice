package com.xulk.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @description:
 * @author:
 * @create: 2019-08-28 22:56
 **/
public class CopyFileByNio {

    /**
     * 基本字节流一次读写一个字节
     */
    public static void copyFile(String srcFile,String destFile) throws IOException {
        FileInputStream fis=new FileInputStream(srcFile);
        FileOutputStream fos=new FileOutputStream(destFile);

        int by=0;
        while((by=fis.read())!=-1){
            fos.write(by);
        }

        fis.close();
        fos.close();
    }

    /**
     * 基本字节流一次读写一个字节数组
     */
    public static void copyFile2(String srcFile,String destFile) throws IOException{
        FileInputStream fis=new FileInputStream(srcFile);
        FileOutputStream fos=new FileOutputStream(destFile);

        int len=0;
        byte[] bys=new byte[1024];
        while((len=fis.read(bys))!=-1){
            fos.write(bys,0,len);
        }

        fis.close();
        fos.close();
    }

    /**
     * 高效字节流一次读写一个字节
     */
    public static void copyFile3(String srcFile,String destFile) throws IOException{
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(destFile));

        int by=0;
        while((by=bis.read())!=-1){
            bos.write(by);
        }

        bis.close();
        bos.close();
    }

    /**
     * 高效字节流一次读写一个字节数组
     */
    public static void copyFile4(String srcFile,String destFile) throws IOException{
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(destFile));

        int len=0;
        byte[] bys=new byte[1024];
        while((len=bis.read(bys))!=-1){
            bos.write(bys,0,len);
        }

        bis.close();
        bos.close();
    }

    /**
     * 使用FileChannel复制文件
     */
    public static void copyFile5(String srcFile,String destFile) throws IOException{
        FileInputStream fis=new FileInputStream(srcFile);
        //获取输入字节流的文件通道
        FileChannel fcin=fis.getChannel();
        FileOutputStream fos=new FileOutputStream(destFile);
        //获取输出字节流的文件通道
        FileChannel fcout=fos.getChannel();

        //为缓冲区分配 1024 个字节
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        while(true){
            //从输入通道中读取数据到缓冲区中
            int r = fcin.read(buffer);
            // read() 返回 -1 表示 EOF
            if(r==-1){
                break;
            }
            //切换读写
            buffer.flip();
            //把缓冲区的内容写入输出文件中
            fcout.write(buffer);
            //清空缓冲区
            buffer.clear();
        }
    }

    public static void main(String[] args) throws IOException {
        String srcFile="E:\\music\\下雨 （录）.mp3";
        String destFile="E:\\test.mp3";
        long start = System.currentTimeMillis();
        //基本字节流 一次读取一个字节
        copyFile(srcFile,destFile); //共耗时：75309毫秒
        //基本字节流 一次读取一个字节数组
        //copyFile2(srcFile,destFile); //共耗时：110毫秒
        //缓冲高效流 一次读取一个字节
        //copyFile3(srcFile,destFile);//共耗时：200毫秒
        //缓冲高效流 一次读取一个字节数组
        //copyFile4(srcFile,destFile);//共耗时：23毫秒
        //fileChannel
        //copyFile5(srcFile,destFile);//共耗时：共耗时：110毫秒
        long end = System.currentTimeMillis();
        System.out.println("共耗时：" + (end - start) + "毫秒");


    }
}
