package com.fr.controller;


import com.fr.commom.utils.AjaxJsonResultWithLayUi;
import com.fr.pojo.User;
import com.fr.pojo.bo.UserBO;
import com.fr.pojo.vo.UserVO;
import com.fr.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.util.List;

/**
 * @author : hong.Four
 * @date : 2020-07-23 09:34
 **/
@Api(value = "用户管理", tags = {"用户管理"})
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public String login(String username, String password, HttpServletResponse resp) {
        System.out.println(username);
        System.out.println(password);
        if (username==null||password==null){
            return "用户名不能为空";
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);//执行登录方法
            System.out.println("登录成功");
            User user = userService.selectUserByUserPhone(username);
            Session session = subject.getSession();
            session.setAttribute("userId", user.getUserId());
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
        return "退出登录成功";
    }

    @ApiOperation(value = "用户注册")
    @PostMapping("/registered")
    public UserVO userRegistered(@RequestParam("phone") String phone, @RequestParam("password") String password) {
        UserBO userBO = new UserBO();
        userBO.setUserPassword(password);
        userBO.setUserPhone(phone);
        User user = userService.userRegistered(userBO);

        UserVO userVO = new UserVO();
        userVO.setUserPhone(user.getUserPhone());
        return userVO;
    }


    @ApiOperation(value = "获取所有用户")
    @GetMapping("/selectAllUser")
    public AjaxJsonResultWithLayUi selectAllUser() {
        List<UserVO> list = userService.selectAllUser();
        if (list.isEmpty()){
            return AjaxJsonResultWithLayUi.errorMsg("没有用户数据查询出错");
        }
        return AjaxJsonResultWithLayUi.ok(list);
    }
}
