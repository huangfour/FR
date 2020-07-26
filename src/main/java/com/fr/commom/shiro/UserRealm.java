package com.fr.commom.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author : hong.Four
 * @date : 2020-07-23 09:14
 * 用户登录认证
 **/
public class UserRealm extends AuthorizingRealm {

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
        String name = "root";
        String password = "123456";

        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        System.out.println(userToken.getUsername());
        System.out.println(password);
        if (!userToken.getUsername().equals(name)) {
            System.out.println(userToken.getUsername());
            return null;
        }
        return new SimpleAuthenticationInfo("",password,"");
    }
}
