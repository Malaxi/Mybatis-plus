package com.neuq.controller;
import com.neuq.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//控制类的文档注释
@Api(tags = "Hello控制类")
@RestController
public class HelloController {
    //接口的文档注释
    @ApiOperation("hello接口")
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
    //接口的文档注释
    @ApiOperation("hello_1接口")
    @PostMapping("/hello_1")
                         //参数的文档类注释
    public String hello1(@ApiParam("用户名") @RequestParam String username){
        return "hello  "+username;
    }
    //接口的文档注释
    @ApiOperation("user接口")
    @PostMapping("/user")
    //接口中含有的实体类会被Swagger扫描到
    public User user(){
        return new User();
    }

}
