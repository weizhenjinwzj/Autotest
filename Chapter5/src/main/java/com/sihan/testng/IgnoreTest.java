package com.sihan.testng;

import org.testng.annotations.Test;

public class IgnoreTest
{
    @Test
    public void ignore1()
    {
        System.out.println("ignore1执行");
    }

    @Test(enabled = false)//忽略测试
    public void ignore2()
    {
        System.out.println("ignore2执行");
    }

    @Test
    public void ignore3()
    {
        System.out.println("ignore3执行");
    }
}