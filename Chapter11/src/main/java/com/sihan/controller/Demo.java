package com.sihan.controller;


import com.sihan.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


//@Log4j
@RestController
@Api(value = "v1",description = "这是我的第一个版本的demo")
@RequestMapping("v1")
public class Demo {

    //首先获取一个执行sql语句的对象

    @Autowired
    private SqlSessionTemplate template;

    @GetMapping(value = "/getUserCount")
    @ApiOperation(value = "可以获取到用户数",httpMethod = "GET")
    public int getUserCount()
    {
       return template.selectOne("getUserCount");
    }

    @PostMapping(value = "/addUser")
   public int addUser(@RequestBody User user )
   {
        return template.insert("addUser",user);
   }

   @PostMapping(value = "/updataUser")
   public int updateUser(@RequestBody User user)
   {
        return template.update("updataUser",user);
   }

    @GetMapping(value = "/deleteUser")
    public int deleteUser(@RequestParam int id)
    {
        return template.update("deleteUser",id);
    }

}
