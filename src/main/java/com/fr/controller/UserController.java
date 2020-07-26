package com.fr.controller;


import com.sun.org.apache.xpath.internal.operations.Mod;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

/**
 * @author : hong.Four
 * @date : 2020-07-23 09:34
 **/
@Api(value = "用户管理", tags = {"用户管理"})
@RestController
@RequestMapping("user")
public class UserController {

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public String login(String username, String password, HttpServletResponse resp) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);//执行登录方法
            System.out.println("登录成功");
            resp.sendRedirect("/doc.html");
            return "登录成功";
        } catch (UnknownAccountException | IOException e) {
            return "登录失败";
        }
    }

    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    public String logout() {
        //登出清除缓存
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return "退出登录失败";
    }
}
