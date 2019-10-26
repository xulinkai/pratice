package com.xulk.tomcat;


import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
* @Description:  模拟服务器向客户端响应数据
* @Date: 2019/8/15  0:11
*/
public class Tomcat_test01 {


    public static void main(String[] args) throws Exception {
        //serverSocket 不能释放资源 否则服务器停止
        ServerSocket serverSocket = null;
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            //1、创建ServerSocket对象，监听本机的8080端口
            serverSocket = new ServerSocket(8080);
            while (true){
                //2、等待来自客户端的请求，获取和客户端对应的socket对象
                socket = serverSocket.accept();
                //3、通过获取到的Socket对象获取输出流对象
                outputStream = socket.getOutputStream();
                //4、通过获取到的输出流对象将HTTP协议的响应部分发送到客户端
                outputStream.write("HTTP/1.1 200 OK\n".getBytes());
                outputStream.write("Content-Type:text/html;charset=utf-8\n".getBytes());
                outputStream.write("Server:Apache-Coyote\n".getBytes());
                outputStream.write("\n".getBytes());
                StringBuffer buffer = new StringBuffer();
                buffer.append("<html>");
                buffer.append("<head><title>我是标题</title></head>");
                buffer.append("<body>");
                buffer.append("<h1> i am xulinkai</h1>");
                buffer.append("<a href='http://www.baidu.com'>baidu</a>");
                buffer.append("</body>");
                buffer.append("</html>");
                outputStream.write(buffer.toString().getBytes());
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //5、释放资源
            if(socket!=null){
                socket.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }


    }
}
