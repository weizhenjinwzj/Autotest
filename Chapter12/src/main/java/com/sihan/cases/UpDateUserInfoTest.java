package com.sihan.cases;

import com.sihan.config.TestConfig;
import com.sihan.model.UpdataUserInfoCase;
import com.sihan.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class UpDateUserInfoTest
{
    @Test(dependsOnGroups = "loginTrue",description = "更新用户信息")
    public void updateUserInfo() throws IOException {
        SqlSession sqlSession= DatabaseUtil.getSqlSession();
        UpdataUserInfoCase updateUserInfoCase= sqlSession.selectOne("updateUserInfoCase",1);
        System.out.println(updateUserInfoCase.toString());
        System.out.println(TestConfig.updataUserInfoUrl);
    }
    @Test(dependsOnGroups = "loginTrue",description = "删除用户信息")
    public void deleteUser() throws IOException {
        SqlSession sqlSession=DatabaseUtil.getSqlSession();
        UpdataUserInfoCase updateUserInfoCase= sqlSession.selectOne("updateUserInfoCase",2);
        System.out.println(updateUserInfoCase.toString());
        System.out.println(TestConfig.updataUserInfoUrl);
    }
}
