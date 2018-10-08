package com.sihan.cases;

import com.sihan.config.TestConfig;
import com.sihan.model.InterfaceName;
import com.sihan.model.LoginCase;
import com.sihan.utils.ConfigFile;
import com.sihan.utils.DatabaseUtil;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest
{
    @BeforeTest(groups="loginTrue",description = "测试准备工作，获取httpclient对象")
    public void beforeTest()
    {
        TestConfig.getUserInfoUrl= ConfigFile.getUrl(InterfaceName.GETUSERINFO);
        TestConfig.getUserListUrl=ConfigFile.getUrl(InterfaceName.GETUSERLIST);
        TestConfig.updataUserInfoUrl=ConfigFile.getUrl(InterfaceName.UPDATEUSERINFO);
        TestConfig.logUrl=ConfigFile.getUrl(InterfaceName.LOGIN);
        TestConfig.addUserUrl=ConfigFile.getUrl(InterfaceName.ADDUSERINFO);

        TestConfig.defaultHttpClient=new DefaultHttpClient();
    }

    @Test(groups = "loginTrue",description = "用户登录成功接口")
    public void loginTrue() throws IOException {
        SqlSession sqlSession= DatabaseUtil.getSqlSession();
        LoginCase loginCase=sqlSession.selectOne("loginCase",1);

        System.out.println(loginCase.toString());
        System.out.println(TestConfig.logUrl);
    }

    @Test(groups = "loginFalse",description = "用户登录成失败接口")
    public void loginFalse() throws IOException {
        SqlSession sqlSession= DatabaseUtil.getSqlSession();
        LoginCase loginCase=sqlSession.selectOne("loginCase",2);

        System.out.println(loginCase.toString());
        System.out.println(TestConfig.logUrl);
    }
}
