package com.sihan.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyHttpClient
{
    @Test
    public void test1() throws IOException {
        String result;//用来存放我们的结果

        HttpGet httpGet = new HttpGet("http://www.baidu.com");

        HttpClient httpClient =new DefaultHttpClient();//用来执行get方法的

        HttpResponse httpResponse=httpClient.execute(httpGet);

        result= EntityUtils.toString(httpResponse.getEntity(), "utf-8");

        System.out.println(result);

    }
}
