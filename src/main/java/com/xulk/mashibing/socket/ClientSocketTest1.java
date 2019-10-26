package com.xulk.mashibing.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @description:
 * @author:
 * @create: 2019-09-23 22:05
 **/
public class ClientSocketTest1 {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",8888);
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            System.out.println(dataInputStream.readUTF());
            dataInputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("程序发生了异常"+e);

        }

    }
}
