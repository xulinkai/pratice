package com.xulk.nio.nio_bio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author:
 * @create: 2019-10-09 23:17
 **/
public class BioServer {


    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[1024];
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(8080));
        while (true) {
            //阻塞 放弃cpu
            Socket socket = serverSocket.accept();
            while (true) {
                // 阻塞 read 代表读了多少字节
                int read = socket.getInputStream().read(bytes);
                if(read>0){
                    String content = new String(bytes);
                    System.out.println(content);
                    bytes = new byte[1024];
                }
            }
        }
    }
}
