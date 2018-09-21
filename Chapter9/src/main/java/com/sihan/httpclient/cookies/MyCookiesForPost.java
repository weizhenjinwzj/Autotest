package com.sihan.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost
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
    public void testPostMethod() throws IOException {
        String uri=bundle.getString("test.postwithcookie");
        String testUrl=this.url+uri;//拼接测试地址

        //声明一个Client对象，用来进行方法的执行
        DefaultHttpClient httpClient=new DefaultHttpClient();
        //声明一个请求方法。这个方法为post
        HttpPost httpPost=new HttpPost(testUrl);
        //添加请求参数
        JSONObject json=new JSONObject();
        json.put("name","wzj");
        json.put("age","18");
        //设置请求头信息
        httpPost.setHeader("content-type","application/json");
        //将参数信息添加到方法中
        StringEntity entity=new StringEntity(json.toString(),"utf-8");
        httpPost.setEntity(entity);
        //声明一个对象进行相应结果的存储
        String result;
        //设置coolie信息
        httpClient.setCookieStore(this.cookieStore);
        //执行post请求方法
        HttpResponse httpResponse=httpClient.execute(httpPost);
        //获取响应结果
         result=EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
         System.out.println(result);
        //判断响应结果是否与预期结果一致
        //将返回的响应结果字符转换为json对象
        JSONObject resuitJson=new JSONObject(result);
        //获取结果值
        String sucess= (String) resuitJson.get("wzj");
        String status=(String) resuitJson.get("status");
        //具体判断返回结果的值
        Assert.assertEquals("success",sucess);
        Assert.assertEquals("1",status);
    }

}
