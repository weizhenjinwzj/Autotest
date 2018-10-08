package com.sihan.utils;

import com.sihan.model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile
{
    private static ResourceBundle bundle=ResourceBundle.getBundle("application", Locale.CANADA);

    public static String getUrl(InterfaceName name)//枚举类限制传其他类型的数据，只能传自己定义的数据；
    {
        String address=bundle.getString("test.url");

        String uri="";

        String testUrl;
        if (name==InterfaceName.GETUSERLIST)
        {
            uri=bundle.getString("getUserList.uri");
        }

        if (name==InterfaceName.GETUSERINFO)
        {
            uri=bundle.getString("getUserInfo.uri");
        }

        if (name==InterfaceName.LOGIN)
        {
            uri=bundle.getString("login.uri");
        }

        if (name==InterfaceName.UPDATEUSERINFO)
        {
            uri=bundle.getString("updataUserInfo.uri");
        }

        if (name==InterfaceName.ADDUSERINFO)
        {
            uri=bundle.getString("addUser.uri");
        }

        testUrl=address+uri;

        return testUrl;
    }
}
