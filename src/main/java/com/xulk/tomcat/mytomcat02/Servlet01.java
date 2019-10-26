package com.xulk.tomcat.mytomcat02;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @description:
 * @author:
 * @create: 2019-08-20 23:20
 **/
public class Servlet01 implements Servlet {

    @Override
    public void init() {
        System.out.println(" my servlet01  init ........");
    }

    @Override
    public void service(InputStream inputStream, OutputStream outputStream) throws Exception {
        System.out.println("servlet01 service ........");
        outputStream.write("i am form servlet01........".getBytes());
        outputStream.flush();
    }

    @Override
    public void destroty() {
        System.out.println("servlet01 destroy ......");
    }
}
