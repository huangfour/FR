package com.fr.commom.utils;

import com.fr.commom.jwt.TokenUtil;
import org.apache.shiro.SecurityUtils;

/**
 * @author : hong.Four
 * @date : 2020-08-02 16:36
 * 用户ID解析(获取当前的用户ID)
 **/
public class UserIdUtil {

    public static Integer getUserId() {
        String token = (String) SecurityUtils.getSubject().getPrincipal();
        Integer userId = TokenUtil.getUserId(token);
        return userId;
    }
}
