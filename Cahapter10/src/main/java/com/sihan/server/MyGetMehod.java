package com.sihan.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@RestController
@Api(value = "/",description = "这是我全部的get方法")
public class MyGetMehod
{
    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获得cookie信息",httpMethod = "GET")
    public String getCookies(HttpServletResponse response)
    {
        //HttpServletRequest  装请求信息的类
        //HttpServletResponse; 装响应信息的类
        Cookie cookie=new Cookie("login","true");
        response.addCookie(cookie);
        return "恭喜你获取cookies信息成功";
    }

    //要求客户端携带cookie访问
    //这是一个需要带cookie信息才能访问的get请求
    @GetMapping(value ="/getWithCookies" )
    @ApiOperation(value = "这是一个需要带cookie信息才能访问的get请求",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest httpServletRequest)
    {
        Cookie[]cookies=httpServletRequest.getCookies();
        if (Objects.isNull(cookies))
        {
            return "这是一个需要带cookie信息才能访问的get请求";
        }

        for (Cookie cookie:cookies)
        {
            if (cookie.getName().equals("login") && cookie.getValue().equals("true"))
            {
                return "这是一个需要带cookie信息才能访问的get请求";
            }
        }
        return "这是一个需要带cookie信息才能访问的get请求";
    }

    //开发一个需要携带参数才能访问的get请求
    //实现方式 key value 模拟获取商品列表
    @GetMapping(value ="/getList" )
    @ApiOperation(value = "一个需要携带参数才能访问的get请求",httpMethod = "GET")
    public Map<String,Integer>getList(@RequestParam Integer start,
                                      @RequestParam Integer end)
    {
        Map<String,Integer> list=new HashMap<>();
        list.put("帽子",400);
        list.put("裤袋",600);
        list.put("鞋子",800);
        return list;
    }

    //开发一个需要携带参数才能访问的get请求
    //实现方式 key value 模拟获取商品列表
    @GetMapping(value ="/myGetList/{start}/{end}" )
    @ApiOperation(value = "一个需要携带参数才能访问的get请求",httpMethod = "GET")
    public Map<String,Integer>myGetList(@PathVariable Integer start,
                                        @PathVariable Integer end)
    {
        Map<String,Integer> mylist=new HashMap<>();
        mylist.put("帽子",400);
        mylist.put("方便面",600);
        mylist.put("鞋子",800);
        return mylist;
    }
}
