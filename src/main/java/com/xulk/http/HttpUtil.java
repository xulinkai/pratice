package com.xulk.http;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.*;

/**
 * Created by xulinkai on 2019/8/1.
 * http接口测试
 */

/**
 * @param * @param null
 * @author xulinkai
 * @date 2020/1/2
 * @description <dependency>
 * <groupId>com.google.guava</groupId>
 * <artifactId>guava</artifactId>
 * <version>18.0</version>
 * </dependency>
 */
@Slf4j
public class HttpUtil {

    private static final int TIME = 30000;

    /**
     * @param
     * @author xulinkai
     * @date 2020/1/2
     * @description get方式请求  返回请求响应的文本
     */
    public static String doGetReturnText(String url) throws Exception {
        String resultText = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            System.out.println();
            log.info("doGetReturnText:url:" + url);
            HttpGet httpGet = new HttpGet(url);
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(TIME)//服务器响应超时时间
                    .setConnectTimeout(TIME)//连接服务器超时时间
                    .build();
            httpGet.setConfig(requestConfig);
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                resultText = EntityUtils.toString(entity, "UTF-8");
            }
            if (resultText.length() < 5000) {
                log.info("doGetReturnText:resultText:" + resultText);
            } else {
                log.info("doGetReturnText:resultText:too long");
            }
        } catch (Exception e) {
            log.error("doGetReturnText error:" + e.getMessage());
            throw e;
        } finally {
            if (response != null) {
                response.close();
            }
            httpClient.close();
        }
        return resultText;

    }

    /**
     * 执行GET请求
     *
     * @param url 请求的url。参数直接拼接在url后面
     * @return 返回请求响应的状态码，请求成功返回200
     * @throws Exception
     */
    public static int doGetReturnStatus(String url) throws Exception {
        int status = HttpStatus.SC_NOT_FOUND;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(new HttpGet(url));
            status = response.getStatusLine().getStatusCode();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (response != null) {
                response.close();
            }
            httpClient.close();
        }
        return status;
    }

    /**
     * 执行一个HTTP POST请求，返回请求响应的HTML
     *
     * @param url    请求的URL地址
     * @param params 请求的查询参数,可以为null
     * @return 请求响应的HTML
     */
    public static String doPostReturnText(String url, Map<String, String> params) throws Exception {
        String resultText = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        HttpPost httpPost;
        try {
            httpPost = new HttpPost(url);
            if (MapUtils.isNotEmpty(params)) {
                httpPost.setEntity(new UrlEncodedFormEntity(buildPostParams(params)));
            }
            log.info("doPostReturnText:url:" + url + ":" + params);
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                resultText = EntityUtils.toString(entity, "UTF-8");
            }
            log.info("doPostReturnText:resultText：" + resultText);
        } catch (Exception e) {
            log.error("doPostReturnText params error:" + e.getMessage());
            throw e;
        } finally {
            if (response != null) {
                response.close();
            }
            httpClient.close();
        }
        return resultText;
    }

    /**
     * 执行一个HTTP POST请求，返回请求响应的状态码
     *
     * @param url    请求的url地址
     * @param params 请求的查询参数,可以为null
     * @return 请求响应的状态码
     */
    public static int doPostReturnStatus(String url, Map<String, String> params) throws Exception {
        int status = HttpStatus.SC_NOT_FOUND;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            if (MapUtils.isNotEmpty(params)) {
                httpPost.setEntity(new UrlEncodedFormEntity(buildPostParams(params)));
            }
            response = httpClient.execute(httpPost);
            status = response.getStatusLine().getStatusCode();
        } catch (Exception e) {
            log.error("doPostReturnStatus params error:" + e.getMessage());
        } finally {
            if (response != null) {
                response.close();
            }
            httpClient.close();
        }
        return status;
    }

    /**
     * 执行一个HTTP POST请求，返回请求响应的HTML
     *
     * @param url  请求的url
     * @param body 请求的body体
     * @return 请求响应的HTML
     */
    public static String doPostReturnText(String url, String body) throws Exception {
        return doPostReturnText(url, "application/x-www-form-urlencoded", body);
    }

    /**
     * 执行一个HTTP POST请求，返回请求响应的HTML
     *
     * @param url         请求的url
     * @param contentType 请求的内容类型
     * @param body        请求的body体
     * @return
     * @throws Exception
     */
    public static String doPostReturnText(String url, String contentType, Map headMap, String body) throws Exception {
        String resultText = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            if (headMap != null) {
                Iterator<Map.Entry<String, String>> iterator = headMap.entrySet().iterator();
                Map.Entry<String, String> entry;
                while (iterator.hasNext()) {
                    entry = iterator.next();
                    httpPost.setHeader(entry.getKey(), entry.getValue());
                }
            }
            StringEntity reqEntity = new StringEntity(body, "UTF-8");
            if (StringUtils.isNotBlank(contentType)) {
                reqEntity.setContentType(contentType);
            }
            httpPost.setEntity(reqEntity);
            //设置超时时间
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(TIME).setConnectTimeout(TIME).build();
            httpPost.setConfig(requestConfig);
            log.info("doPostReturnText:url:" + url + ":" + contentType + ":" + headMap + ":" + body);
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                resultText = EntityUtils.toString(entity, "UTF-8");
            }
            log.info("doPostReturnText:resultText:" + resultText);
        } catch (Exception e) {
            log.error("doPostReturnText body error:" + e);
            throw e;
        } finally {
            if (response != null) {
                response.close();
            }
            httpClient.close();
        }
        return resultText;
    }

    /**
     * 执行一个HTTP POST请求，返回请求响应的HTML
     *
     * @param url         请求的url
     * @param contentType 请求的内容类型
     * @param body        请求的body体
     * @param timeOut     超时时间
     * @return
     * @throws Exception
     */
    public static String doPostReturnText(String url, String contentType, Map headMap, String body, int timeOut) throws Exception {
        String resultText = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            if (headMap != null) {
                Iterator<Map.Entry<String, String>> iterator = headMap.entrySet().iterator();
                Map.Entry<String, String> entry;
                while (iterator.hasNext()) {
                    entry = iterator.next();
                    httpPost.setHeader(entry.getKey(), entry.getValue());
                }
            }
            StringEntity reqEntity = new StringEntity(body, "UTF-8");
            if (StringUtils.isNotBlank(contentType)) {
                reqEntity.setContentType(contentType);
            }
            httpPost.setEntity(reqEntity);
            //设置超时时间
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeOut).setConnectTimeout(timeOut).build();
            httpPost.setConfig(requestConfig);
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                resultText = EntityUtils.toString(entity, "UTF-8");
            }
        } catch (Exception e) {
            log.error("doPostReturnText body error:" + e);
            throw e;
        } finally {
            if (response != null) {
                response.close();
            }
            httpClient.close();
        }
        return resultText;
    }

    /**
     * 执行一个HTTP POST请求，返回请求响应的HTML
     *
     * @param url         请求的url
     * @param contentType 请求的内容类型
     * @param body        请求的body体
     * @return
     * @throws Exception
     */
    public static String doPostReturnText(String url, String contentType, String body) throws Exception {
        return doPostReturnText(url, contentType, null, body);
    }


    /**
     * 执行一个HTTP POST请求，返回请求响应的HTML
     *
     * @param url         请求的url
     * @param contentType 请求的内容类型
     * @param body        请求的body体
     * @param timeOut     超时时间
     * @return
     * @throws Exception
     */
    public static String doPostReturnText(String url, String contentType, String body, int timeOut) throws Exception {
        return doPostReturnText(url, contentType, null, body, timeOut);
    }

    /**
     * 执行一个HTTP POST请求，返回请求响应的状态码
     *
     * @param url  请求的url
     * @param body 请求的body体
     * @return 请求响应的状态码
     */
    public static int doPostReturnStatus(String url, String body) throws Exception {
        int status = HttpStatus.SC_NOT_FOUND;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            StringEntity reqEntity = new StringEntity(body, "utf-8");
            httpPost.setEntity(reqEntity);
            response = httpClient.execute(httpPost);
            status = response.getStatusLine().getStatusCode();
        } catch (Exception e) {
            log.error("doPostReturnStatus body error:" + e.getMessage());
        } finally {
            if (response != null) {
                response.close();
            }
            httpClient.close();
        }
        return status;
    }

    /**
     * 组装post请求的参数
     *
     * @param params map参数
     * @return list参数
     */
    private static List buildPostParams(Map params) {
        List<NameValuePair> nvps = new ArrayList<>();
        Set<Map.Entry<String, String>> set = params.entrySet();
        for (Map.Entry<String, String> entry : set) {
            nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        return nvps;
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            String result = doGetReturnText("http://10.150.30.134:8080/v1/refuce_code/queryOneHopRefuceCounts?intopieceId=1234556&type=1");
            System.out.println(result);
            System.out.println(i);
        }

    }

}
