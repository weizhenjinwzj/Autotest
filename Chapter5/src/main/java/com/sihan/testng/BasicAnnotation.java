package com.sihan.testng;

import org.testng.annotations.*;

public class BasicAnnotation
{
    @Test
    public void testcase1()
    {
        System.out.println("这是测试用例1");
    }
    @Test
    public void testcase2()
    {
        System.out.println("这是测试用例2");
    }
    @BeforeTest
    public void beforeMethod()
    {
        System.out.println("BeforeTest这是测试方法之前运行的");
    }
    @AfterTest
    public void afterMethod()
    {
        System.out.println("AfterTest这是在测试方法之后运行的");
    }

    @BeforeClass
    public void beforeClass()
    {
        System.out.println("BeforeClass这是在类运行之前运行的");
    }

    @AfterClass
    public void afterClass ()
    {
        System.out.println("AfterClass这是在类运行之后运行的");
    }

    @BeforeSuite
    public void beforeSuite()
    {
        System.out.println("BeforeSuite测试套件");
    }

    @AfterSuite
    public void afterSuite()
    {
        System.out.println("AfterSuite测试套件");
    }
}
