package com.xulk.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by xulinkai on 2019/8/1.
 * http接口测试
 */
public class HttpUtil {

    /**
     * get方式调用http接口
     */
    public void httpGet(){
        String methodUrl = "www.baidu.com";
        HttpURLConnection connection = null;
        BufferedReader bufferedReader = null;
        String line = null;
        try {
            URL url = new URL(methodUrl);
            connection = (HttpURLConnection) url.openConnection();//根据url生成methodUrl
            connection.setRequestMethod("GET");//默认get请求
            connection.connect();
            if(connection.getResponseCode()==HttpURLConnection.HTTP_OK){

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
