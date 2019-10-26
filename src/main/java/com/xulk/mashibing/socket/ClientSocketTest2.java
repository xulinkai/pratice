package com.xulk.mashibing.socket;

import java.io.*;
import java.net.Socket;

/**
 * @description:
 * @author:
 * @create: 2019-09-23 22:05
 **/
public class ClientSocketTest2 {

    public static void main(String[] args) {
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            Socket socket = new Socket("127.0.0.1",5888);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            //客户端 先读再写
            System.out.println("客户端从服务端拿到的数据为："+dataInputStream.readUTF());
            dataOutputStream.writeUTF("hi 这是客户端往服务端写的内容");
            dataOutputStream.close();
            dataInputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("程序发生了异常"+e);

        }

    }
}
