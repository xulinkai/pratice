package com.xulk.mashibing.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:  服务端 一边读一边写
 * @author:
 * @create: 2019-09-23 22:05
 **/
public class ServerSocketTest2 {

    public static void main(String[] args) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            ServerSocket serverSocket = new ServerSocket(5888);
            Socket socket = serverSocket.accept();
            outputStream = socket.getOutputStream();
            inputStream = socket.getInputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            //服务端 先写再读  （服务端 客户端 一个先写后读  一个先读后写）
            dataOutputStream.writeUTF("hi,这是服务端往客户端写的内容。");
            String s = dataInputStream.readUTF();
            System.out.println("服务端从客户端拿到的数据为："+s);
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("程序出错" + e);
            e.printStackTrace();
        }
    }
}
