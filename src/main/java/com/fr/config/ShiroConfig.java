package com.fr.config;

import com.fr.commom.shiro.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : hong.Four
 * @date : 2020-07-23 09:12
 **/
@Configuration
public class ShiroConfig {

    //ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManage") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        bean.setLoginUrl("/toLogin");
        //添加Shiro的内置过滤器
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/toLogin","anon"); //跳转登录页面放行
        filterMap.put("/user/login","anon"); //登录请求 放行
        filterMap.put("/**","authc"); //认证
        bean.setFilterChainDefinitionMap(filterMap);

        return bean;
    }

    //DefaultWebSecurityManager
    @Bean(name = "securityManage")
    public DefaultWebSecurityManager getDefaultWebSecurityManage(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //创建realm对象
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }
}
