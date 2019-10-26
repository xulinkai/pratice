package com.xulk.nio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @description:
 * @author:
 * @create: 2019-08-29 22:22
 **/
public class NioClient_Selector {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream out = socket.getOutputStream();
        String s = "hello world";
        out.write(s.getBytes());
        out.close();
    }
}
