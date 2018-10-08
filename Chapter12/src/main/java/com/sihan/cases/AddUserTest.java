package com.sihan.cases;

import com.sihan.config.TestConfig;
import com.sihan.model.AddUserCase;
import com.sihan.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddUserTest
{
    @Test(dependsOnGroups = "loginTrue",description = "添加用户接口测试")
    public void addUser() throws IOException {
        SqlSession sqlSession= DatabaseUtil.getSqlSession();
        AddUserCase addUserCase=sqlSession.selectOne("addUserCase",1);
        System.out.println(addUserCase.toString());
        System.out.println(TestConfig.addUserUrl);
    }
}
