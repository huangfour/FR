package com.fr.commom.jwt;


import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.HostAuthenticationToken;
import org.apache.shiro.authc.RememberMeAuthenticationToken;

/**
 * @ Program       :  com.ljnt.blog.po.JWTToken
 * @ Description   :  配置token实体bean进行拓展，使其适应shiro框架
 * @ Author        :  lj
 * @ CreateDate    :  2020-2-4 17:56
 */
public class JWTToken implements HostAuthenticationToken, RememberMeAuthenticationToken {
    private String token;
    private String host;
    private boolean rememberMe;

    public JWTToken(String token, String host, boolean rememberMe) {
        this.rememberMe = rememberMe;
        this.host = host;
        this.token = token;
    }

    public JWTToken(String token, String host) {
        this.rememberMe = false;
        this.host = host;
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public String getHost() {
        return host;
    }

    @Override
    public boolean isRememberMe() {
        return rememberMe;
    }
}