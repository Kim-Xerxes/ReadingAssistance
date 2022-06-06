package com.demo.Controller;

import com.demo.Entity.User;
import com.demo.Response.ResponseCode;
import com.demo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Account/")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    // 响应登录，请求
    // 登录成功则返回user，否则返回空字符串；如果不存在用户则空字符串
    @PostMapping("signIn")
    @org.springframework.web.bind.annotation.ResponseBody
    public com.demo.Response.ResponseBody signUp(@RequestBody User u){
        if(service.existsByName(u)){
            User user = service.findUserByNameAndPassword(u.getName(), u.getPassword());
            return new com.demo.Response.ResponseBody(user != null ? ResponseCode.SIGN_IN_SUCCESS : ResponseCode.WRONG_PASSWORD, user != null ? user : "");
        }
        return new com.demo.Response.ResponseBody(ResponseCode.NO_ACCOUNT, "");
    }

    // 查看所有用户信息
    @GetMapping("findAll")
    @org.springframework.web.bind.annotation.ResponseBody
    public com.demo.Response.ResponseBody findAll(){
        return new com.demo.Response.ResponseBody(1, service.findAll());
    }

    // 响应注册
    // 如果存在uid，则返回空字符串；如果不存在则直接将User对象加入数据库
    @PostMapping("register")
    @org.springframework.web.bind.annotation.ResponseBody
    public com.demo.Response.ResponseBody register(@RequestBody User u){
        if(!service.existsByName(u)){
            service.insert(u);
            return new com.demo.Response.ResponseBody(ResponseCode.REGISTER_SUCCESS, u);
        }
        return new com.demo.Response.ResponseBody(ResponseCode.REGISTER_FAIL, "");
    }

    // 响应账号信息修改
    // 返回响应码
    @PostMapping("update")
    @org.springframework.web.bind.annotation.ResponseBody
    public com.demo.Response.ResponseBody update(@RequestBody User u){
        return new com.demo.Response.ResponseBody(service.update(u) ? ResponseCode.UPDATE_SUCCESS : ResponseCode.UPDATE_FAILED, "");
    }

    // 响应账号删除
    // 返回响应码
    @PostMapping("delete")
    @org.springframework.web.bind.annotation.ResponseBody
    public com.demo.Response.ResponseBody deleteByName(@RequestBody User u){
        return new com.demo.Response.ResponseBody(service.deleteByName(u.getName()) ? ResponseCode.DELETE_SUCCESS : ResponseCode.DELETE_FAILED, "");
    }

    // 测试响应
    @GetMapping("test")
    public String test(){
        return "test";

    }
}
