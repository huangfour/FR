package com.fr.commom.shiro;

import com.fr.mapper.UserMapper;
import com.fr.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : hong.Four
 * @date : 2020-07-23 09:14
 * 用户登录认证
 **/
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行了授权");
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了认证");
        //获取当前用户
        //用户名，密码
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        String password =userService.selectPasswordByUserPhone(userToken.getUsername()) ;
        return new SimpleAuthenticationInfo("",password,"");
    }
}
