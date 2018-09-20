package com.sihan.testng.groups;

import org.testng.annotations.Test;

@Test (groups = "teacher")
public class GroupsOnCLASS3
{
    public void teacher1()
    {
        System.out.println("GroupsOnCLASS333中的teacher1运行");
    }

    public void teacher2()
    {
        System.out.println("GroupsOnCLASS333中的teacher2运行");
    }
}
