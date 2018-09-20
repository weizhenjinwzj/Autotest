package com.sihan.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig
{
    @BeforeSuite
    public void beforeSuite()
    {
        System.out.println("beforeSuite运行了啦");
    }

    @AfterSuite
    public void afterSuite()
    {
        System.out.println("AfterSuite运行了啦");
    }
    @BeforeTest
    public void beforeTest()
    {
        System.out.println("BeforeTest");
    }

    @AfterTest
    public void afterTest()
    {
        System.out.println("AfterTest");
    }
}
