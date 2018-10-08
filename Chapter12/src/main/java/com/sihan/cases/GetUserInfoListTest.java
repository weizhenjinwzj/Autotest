package com.sihan.cases;

import com.sihan.config.TestConfig;
import com.sihan.model.GetUserListCase;
import com.sihan.utils.DatabaseUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetUserInfoListTest
{
    @Test(dependsOnGroups = "loginTrue",description = "获取性别为男的用户")
    public void getUserListInfo() throws IOException {
        SqlSession sqlSession= DatabaseUtil.getSqlSession();
        GetUserListCase getUserList=sqlSession.selectOne("getUserListCase",1);
        System.out.println(getUserList.toString());
        System.out.println(TestConfig.getUserListUrl);
    }
}
