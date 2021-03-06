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
    private String url;
    private ResourceBundle bundle;//测试之前读取配置信息
    private CookieStore cookieStore;//用来存储cookies信息的变量
    @BeforeTest
    public void beforeTest()
    {
        bundle=ResourceBundle.getBundle("application", Locale.CHINA);//自动读取resource下的结尾properties文件
        url=bundle.getString("test.url");//获取每个接口相似的‘http://localhost:8087’
    }
    @Test
    public void testGetCookies() throws IOException {

        String result;
        //从配置文件中拼接url
        //String testUrl=bundle.getString("test.url");
        String getCookieUri=bundle.getString("getCookie.uri");

        HttpGet httpGet=new HttpGet(this.url+getCookieUri);

        DefaultHttpClient  httpClient=new DefaultHttpClient();
        HttpResponse response=httpClient.execute(httpGet);
        result= EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        //获取cookies信息
        cookieStore=httpClient.getCookieStore();
        List<Cookie> cookieList=cookieStore.getCookies();

        for (Cookie cookie:cookieList)
        {
            String key=cookie.getName();
            String value=cookie.getValue();
            System.out.println("cookiename="+key+"   cookievalue="+value);
        }

    }
    @Test(dependsOnMethods ={"testGetCookies"} )
    public void testGetWithCookie() throws IOException {
        String uri=bundle.getString("test.getwithcookies");
        String testurl=this.url+uri;//字符串拼接时注意顺序

        HttpGet httpGet=new HttpGet(testurl);
        DefaultHttpClient httpClient=new DefaultHttpClient();

        //设置cookie信息
        httpClient.setCookieStore(this.cookieStore);

        HttpResponse httpResponse= httpClient.execute(httpGet);

       // 获取响应的状态码
        int statusCode=httpResponse.getStatusLine().getStatusCode();

        System.out.println("statuscode="+statusCode);

        if (statusCode==200)
        {
            String result=EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
            System.out.println(result);
        }


    }
}
