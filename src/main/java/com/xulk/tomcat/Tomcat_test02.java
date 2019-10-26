package com.xulk.tomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @description:  模拟浏览器获取服务端资源
 * @author:
 * @create: 2019-08-15 23:29
 **/
public class Tomcat_test02 {

    public static void main(String[] args) throws IOException {
        //1、建立一个socket对象，配置需要监听的域名和端口
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            socket = new Socket("www.itcast.cn",80);
            //2、获取输出流对象
            outputStream = socket.getOutputStream();
            //3、获取输入流对象
            inputStream = socket.getInputStream();
            //4、将HTTP协议请求部分发送到服务端
            outputStream.write("GET /subject/about/index.html HTTP/1.1\n".getBytes());
            outputStream.write("HOST:www.itcast.cn\n".getBytes());
            outputStream.write("\n".getBytes());
            //5、读取来自服务端的数据打印到控制台
            int i = 0;
            while ((i=inputStream.read()) != -1){
                System.out.print((char) i);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //6、释放资源
            if (socket != null) {
                socket.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}
