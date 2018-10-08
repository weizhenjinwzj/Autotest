package com.sihan.config;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;

public class TestConfig
{
    //用来装一些变量
    public static String logUrl;
    public static String updataUserInfoUrl;
    public static String getUserListUrl;
    public static String getUserInfoUrl;
    public static String addUserUrl;

    public static DefaultHttpClient defaultHttpClient;
    public static CookieStore cookieStore;
}
