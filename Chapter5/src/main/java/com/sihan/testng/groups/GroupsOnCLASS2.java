package com.sihan.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsOnCLASS2
{
    public void stu1()
    {
        System.out.println("GroupsOnCLASS222中的stu1运行");
    }

    public void stu2()
    {
        System.out.println("GroupsOnCLASS222中的stu2运行");
    }
}
