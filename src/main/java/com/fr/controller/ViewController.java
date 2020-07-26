package com.fr.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author : hong.Four
 * @date : 2020-07-24 10:48
 * 视图跳转控制器
 **/
@Controller
@ApiIgnore
public class ViewController {

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

}
