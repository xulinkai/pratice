package com.xulk.mashibing.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author:
 * @create: 2019-09-23 22:05
 **/
public class ServerSocketTest1 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            OutputStream outputStream = socket.getOutputStream();
            //相当于东西写到了客户端
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF("adress:" + socket.getInetAddress() + " port:" + socket.getPort() + " bye bye");
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("程序出错" + e);
            e.printStackTrace();
        }
    }
}
