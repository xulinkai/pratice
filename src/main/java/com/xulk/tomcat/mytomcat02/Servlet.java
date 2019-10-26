package com.xulk.tomcat.mytomcat02;

import java.io.InputStream;
import java.io.OutputStream;

public interface Servlet {

    public void init();

    public void service(InputStream inputStream, OutputStream outputStream) throws Exception;

    public void destroty();
}
