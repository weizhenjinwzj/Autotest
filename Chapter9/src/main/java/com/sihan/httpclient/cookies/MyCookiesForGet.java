package com.sihan.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet
{
//    private String url;
    private ResourceBundle bundle;//测试之前读取配置信息
    @BeforeTest
    public void beforeTest()
    {
        bundle=ResourceBundle.getBundle("application", Locale.CHINA);//自动读取resource下的结尾properties文件
//        url=bundle.getString("test.url");
    }
    @Test
    public void testGetCookies() throws IOException {

        String result;
        //从配置文件中拼接url
        String testUrl=bundle.getString("test.url");
        String getCookieUri=bundle.getString("getCookie.uri");

        HttpGet httpGet=new HttpGet("http://192.168.0.150:5050/wbs/login_page");

        DefaultHttpClient  httpClient=new DefaultHttpClient();
        HttpResponse response=httpClient.execute(httpGet);
        result= EntityUtils.toString(response.getEntity(),"utf-8");
        //System.out.println(result);

        //获取cookies信息
        CookieStore cookieStore=httpClient.getCookieStore();
        List<Cookie> cookieList=cookieStore.getCookies();

        for (Cookie cookie:cookieList)
        {
            String key=cookie.getName();
            String value=cookie.getValue();
            System.out.println("cookiename="+key+"   cookievalue="+value);
        }

    }
}
