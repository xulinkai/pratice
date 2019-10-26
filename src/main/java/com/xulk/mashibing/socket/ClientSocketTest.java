package com.xulk.mashibing.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @description:
 * @author:
 * @create: 2019-09-22 15:27
 **/
public class ClientSocketTest {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",6666);
        OutputStream outputStream = socket.getOutputStream();
        //相当于东西写到了服务器
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF("hello world !");
        dataOutputStream.flush();
        dataOutputStream.close();
    }
}
