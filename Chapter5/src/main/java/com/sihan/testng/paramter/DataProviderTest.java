package com.sihan.testng.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest
{
    @Test(dataProvider = "data")
    public void testDataProvider(String name,int age)
    {
        System.out.println("name="+name+"   ;age="+age);
    }

    @DataProvider(name = "data")
    public Object[][] providerData()
    {
        Object[][] o=new Object[][]{
            {"zhangsan",10},{"lisi",12},{"wangwu",1}
            };
            return o;
    }
    @Test(dataProvider = "methodData")
    public void test1(String name,int age)
    {
        System.out.println("test111方法 name="+name+"  ;age="+age);
    }
    @Test(dataProvider = "methodData")
    public void test2(String name,int age)
    {
        System.out.println("test222方法 name="+name+"  ;age="+age);
    }

    @DataProvider(name = "methodData")
    public Object[][] methodDataTeat(Method method)
    {
        Object[][] result=null;

        if (method.getName().equals("test1"))
        {
            result=new Object[][]{
                    {"zhangsan",120},{"lisi",13},{"wangwu",1}
            };
        }
        else if (method.getName().equals("test2"))
        {
            result=new Object[][]{
                    {"zhangsan1",120},{"lisi1",13},{"wangwu1",21}
            };
        }

        return result;
    }

}
