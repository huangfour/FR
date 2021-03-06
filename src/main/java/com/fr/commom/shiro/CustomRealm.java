package com.fr.commom.shiro;


import com.fr.commom.jwt.JWTToken;
import com.fr.commom.jwt.TokenUtil;
import com.fr.commom.utils.AjaxJsonResultWithLayUi;
import com.fr.pojo.User;
import com.fr.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : hong.Four
 * @date : 2020-07-23 09:14
 * 用户登录认证
 **/
@Component
public class CustomRealm extends AuthorizingRealm {

    private final Logger logger = LoggerFactory.getLogger(CustomRealm.class);

    @Autowired
    UserService userService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 用户授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("用户授权");
        String username = TokenUtil.getAccount(principalCollection.toString());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //正确的业务流程是到数据库拿该用户的权限再去进行授权的，这里只是简单的直接授权
        if (username.equals("admin")) {
            Set<String> role = new HashSet<>();
            role.add("admin");
            info.setRoles(role);
        } else {
            Set<String> role = new HashSet<>();
            role.add("user");
            info.setRoles(role);
        }
        return info;
    }

    /**
     * 用户身份认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取token并从token当中解析出用户账号
        JWTToken jwtToken = (JWTToken) authenticationToken;
        String token = (String) jwtToken.getCredentials();
        String host = jwtToken.getHost();
        String username = TokenUtil.getAccount(token);
        logger.info("用户主机为：" + host+","+"用户名为："+username+"登录成功");
        //这里要去数据库查找是否存在该用户，这里直接放行
        User user = userService.selectUserByUserPhone(username);
        if (user == null) {
            throw new AuthenticationException("无此用户");
        }
        return new SimpleAuthenticationInfo(token, token, "MyRealm");
    }
}
