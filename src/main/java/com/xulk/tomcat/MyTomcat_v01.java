package com.xulk.tomcat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description: 需求：
 * 1、在webcontent下发布静态资源，demo1.html  demo2.html
 * 2、启动tomcat服务器
 * 3、当客户端对服务端发起不同的请求的时候，服务端可以将对应的html资源响应给客户端
 * <p>
 * 步骤：
 * 1、建立ServerSocket对象，监听本机8080端口，等待来自客户端的请求，
 * 2、获取到Socket对象
 * 3、通过Socket对象，获取输入流和输出流对象
 * 4、通过输入流对象读取来自客户端的数据，分析本次HTTP请求需要获取的资源的路径 demo.html
 * 5、读取webContent下的html资源到内存当中，
 * 6、通过输出流对象将HTTP协议的响应行和响应头的部分发送到客户端
 * 7、将内存当中的html资源作为响应体发送到客户端
 * 8、释放资源
 * <p>
 * 准备工作：
 * 定义静态变量，WEB.ROOT，用于存放webContent目录的绝对路径
 * 定义静态变量url，用于存放本次请求服务端的静态资源的名称
 * @author:
 * @create: 2019-08-19 23:28
 **/
public class MyTomcat_v01 {


    //webContent 目录的绝对路径
    public static String WEB_ROOT = System.getProperty("user.dir") + "\\" + "webContent";

    //请求的服务端对应的静态资源名称
    private static String url = "";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            //创建ServerSocket对象，监听本机的80端口，等待来自客户端的请求，
            serverSocket = new ServerSocket(8080);
            while (true) {//死循环目的是让所有的请求都可以得到响应，
                //没有请求进来的时候，会阻塞在这里  获取到客户端对应的socket
                socket = serverSocket.accept();
                //获取输入流
                inputStream = socket.getInputStream();
                //获取输出流
                outputStream = socket.getOutputStream();
                //读取HTTP协议请求部分数据，解析请求行，获取本次请求的静态资源名称
                parse(inputStream);
                //输出静态资源到客户端
                sendStaticResource(outputStream);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源，serverSocket不能关闭，相当于服务器停了
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (socket != null) {
                socket.close();
            }

        }
    }

    /**
     * @Description: 获取http协议的请求部分，截取客户端要访问的资源名称，将值赋给url
     * 准备：
     * 定义一个变量，存放HTTP协议请求部分数据，
     * 定义一个数组，存放HTTP协议请求部分数据
     * 定义一个变量i，代表读取数据到数组之后，数据量的大小
     * 读取客户端发送过来的数据，将数据读取到字节数组buffer中，i代表数据量的大小
     * 遍历字节数组，将数组中的数据追加到content变量中，
     * 打印HTTP协议请求部分数据
     * 截取客户端要请求的资源路径demo.html.复制给url
     * @Param:
     * @return:
     * @Date: 2019/8/20  0:03
     */
    public static void parse(InputStream inputStream) throws IOException {
        StringBuffer content = new StringBuffer();
        byte[] bytes = new byte[2048];
        int i = -1;
        i = inputStream.read(bytes);
        for (int j = 0; j < i; j++) {
            content.append((char) bytes[j]);
        }
        parseUrl(content.toString());
    }

    /**
     * @Description: 从请求的内容当中截取 要访问的目标资源名称
     * @Param:
     * @return:
     * @Date: 2019/8/20  22:16
     */
    public static void parseUrl(String content) {
        int index01, index02;
        index01 = content.indexOf(" ");
        if (index01 > -1) {
            index02 = content.indexOf(" ", index01 + 1);
            if (index02 > index01) {
                url = content.substring(index01 + 2, index02);
                System.out.println("url:" + url);
            }
        }
    }

    /**
     * @Description: 输出静态资源到客户端
     * 准备：
     * 定义一个字节数组，用于存放本次请求静态资源demo.html的内容
     * 定义一个文件输入流，用于获取demo.html的内容
     * 创建文件对象file，代表本次要请求的资源demo.html中的内容
     * 如果文件存在
     * 向客户端输出HTTP协议的响应行、头
     * 获取文件的输入流对象
     * 读取静态资源demo.html中的内容到字节数组中
     * 将读取到的数组中的内容通过输出流发送到客户端
     * 如果文件不存在
     * 向客户端输出文件不存在的信息
     * 释放文件输出流对象
     * @Param:
     * @return:
     * @Date: 2019/8/20  0:06
     */
    public static void sendStaticResource(OutputStream outputStream) throws IOException {
        byte[] bytes = new byte[2048];
        FileInputStream fileInputStream = null;
        try {
            File file = new File(WEB_ROOT, url);
            if (file.exists()) {
                outputStream.write("HTTP/1.1 200 OK\n".getBytes());
                outputStream.write("Content-Type:text/html;charset=utf-8\n".getBytes());
                outputStream.write("Server:Apache-Coyote/1.1\n".getBytes());
                outputStream.write("\n\n".getBytes());
                fileInputStream = new FileInputStream(file);
                int i = 0;
                while ((i = fileInputStream.read(bytes)) != -1){
                    outputStream.write(bytes,0,i);
                }
            } else {
                outputStream.write("HTTP/1.1 404 not found\n".getBytes());
                outputStream.write("Content-Type:text/html;charset=utf-8\n".getBytes());
                outputStream.write("Server:Apache-Coyote/1.1\n".getBytes());
                outputStream.write("\n".getBytes());
                outputStream.write("file not found ......".getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }

        }


    }


}
