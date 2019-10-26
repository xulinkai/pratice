package com.xulk.mashibing.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author:
 * @create: 2019-09-22 15:24
 **/
public class ServerSocketTest {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        //死循环 保证可以接收到所有的 请求
        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            //从客户端把东西读出来
            System.out.println(dataInputStream.readUTF());//readUTF()  阻塞式的
            dataInputStream.close();
            socket.close();
        }
    }
}
