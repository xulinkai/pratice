package com.xulk.nio.nio_bio;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @description:
 * @author:
 * @create: 2019-10-09 23:35
 **/
public class NioClient1 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8080);
        while (true){
            Scanner scanner = new Scanner(System.in);
            String content = scanner.next();
            socket.getOutputStream().write(content.getBytes());
        }
    }
}
