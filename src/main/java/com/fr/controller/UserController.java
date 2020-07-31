package com.fr.controller;


import com.fr.commom.jwt.TokenUtil;
import com.fr.commom.utils.AjaxJsonResultWithLayUi;
import com.fr.commom.utils.RedisUtil;
import com.fr.mapper.UserMapper;
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
import org.springframework.transaction.annotation.Transactional;
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

    @Autowired
    RedisUtil redisUtil;


    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public AjaxJsonResultWithLayUi login(@RequestBody UserVO userVO, HttpServletResponse response) {
        System.out.println(userVO.getUserPhone());
        System.out.println(userVO.getUserPassword());
        if (userVO.getUserPhone() == null || userVO.getUserPassword() == null) {
            return AjaxJsonResultWithLayUi.errorMsg("用户名不能为空");
        }
        //去数据库拿密码验证用户名密码，这里直接验证
        User user = userService.selectUserByUserPhone(userVO.getUserPhone());
        String password = userService.selectPasswordByUserPhone(userVO.getUserPhone());
        if (user == null) {
            return AjaxJsonResultWithLayUi.errorMsg("无此用户");
        }
        if (!userVO.getUserPassword().equals(password)) {
            return AjaxJsonResultWithLayUi.errorMsg("密码错误");
        }
        if (userVO.getUserPhone().equals(user.getUserPhone()) && userVO.getUserPassword().equals(password)) {
            try {
                //生成Token
                Long currentTimeMillis = System.currentTimeMillis();
                String token = TokenUtil.sign(userVO.getUserPhone(), currentTimeMillis);
                System.out.println("生成Token");
                redisUtil.set(userVO.getUserPhone(), currentTimeMillis, TokenUtil.REFRESH_EXPIRE_TIME);
                response.setHeader("Authorization", token);
                response.setHeader("Access-Control-Expose-Headers", "Authorization");
                return AjaxJsonResultWithLayUi.ok("登录成功");

            } catch (UnknownAccountException e) {
                return AjaxJsonResultWithLayUi.errorMsg("登录失败");
            }
        } else {
            return AjaxJsonResultWithLayUi.errorMsg("登录失败");
        }
    }

    @ApiOperation(value = "用户文档登录")
    @PostMapping("/loginSwaggerUi")
    public AjaxJsonResultWithLayUi loginSwaggerUi(String userPhone, String userPassword, HttpServletResponse response) {

        if (userPhone == null || userPassword == null) {
            return AjaxJsonResultWithLayUi.errorMsg("用户名不能为空");
        }
        //生成Token
        try {
            Long currentTimeMillis = System.currentTimeMillis();
            String token = TokenUtil.sign(userPhone, currentTimeMillis);
            redisUtil.set(userPhone, currentTimeMillis, TokenUtil.REFRESH_EXPIRE_TIME);
            response.setHeader("Authorization", token);
            response.setHeader("Access-Control-Expose-Headers", "Authorization");

            return AjaxJsonResultWithLayUi.ok("登录成功");
        } catch (UnknownAccountException e) {
            return AjaxJsonResultWithLayUi.errorMsg("登录失败");
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
        if (list.isEmpty()) {
            return AjaxJsonResultWithLayUi.errorMsg("没有用户数据查询出错");
        }
        return AjaxJsonResultWithLayUi.ok(list);
    }
}
