package com.xulk.tomcat.mytomcat02;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @description:
 * @author:
 * @create: 2019-08-20 23:23
 **/
public class Servlet02 implements Servlet {
    @Override
    public void init() {
        System.out.println("servlet02 init  .......");
    }

    @Override
    public void service(InputStream inputStream, OutputStream outputStream) throws Exception {
        System.out.println("servlet02 service .......");
        outputStream.write("i am from servlet02 .......".getBytes());
        outputStream.flush();

    }

    @Override
    public void destroty() {
        System.out.println("servlet02 destroy .......");
    }
}
