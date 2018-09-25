package com.sihan.server;

import com.sihan.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/",description = "这是我全部的post请求")
@RequestMapping("/v1")
public class MyPostMethod
{
    //这个变量用来装cookie信息的
    private static Cookie cookie;
    //用户登录成功获取到cookie，然后再访问其他接口获取到列表
    @ApiOperation(value = "登录接口，成功后获取cookie信息",httpMethod = "POST")
    @RequestMapping(value = "/Login",method = RequestMethod.POST)
    public String login(HttpServletResponse response,
                        @RequestParam(value = "username",required = true) String username,
                        @RequestParam(value = "password",required = true) String password)
    {

        if (username.equals("wzj")&& password.equals("123456"))
        {
            cookie=new Cookie("login","true");
            response.addCookie(cookie);
            return  "恭喜你登录成功";
        }
        return "用户名或者密码错误";
    }

    @PostMapping(value = "/getUserList")
    @ApiOperation(value = "获取用户列表",httpMethod = "POST")
    public void getUserList(HttpServletRequest request,
                            @RequestBody User u)
    {
        Cookie[] cookie=request.getCookies();

        for (Cookie cookie1 :cookie)
        {
            if(cookie1.getName()=="login"
                    &&cookie1.getValue()=="true"
                    )
            {
                User user=new User();

            }
        }
    }
}
