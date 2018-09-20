package com.sihan.testng;

import org.testng.annotations.Test;

public class ExpectedException
{
    //在期望结果为某一异常的时候，程序跑出了异常
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed()
    {
        System.out.println("这是一个失败的异常测试");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess()
    {
        System.out.println("这是一个失败的异常测试");
        throw new RuntimeException();

    }
}
