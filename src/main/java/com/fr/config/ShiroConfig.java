package com.fr.config;

import com.fr.commom.shiro.ShiroSessionListener;
import com.fr.commom.shiro.UserRealm;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

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
//        filterMap.put("/**","anon"); //登录请求 放行
        bean.setFilterChainDefinitionMap(filterMap);
        return bean;
    }

    //DefaultWebSecurityManager
    @Bean(name = "securityManage")
    public DefaultWebSecurityManager getDefaultWebSecurityManage(@Qualifier("userRealm") UserRealm userRealm,@Qualifier("sessionManager")SessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        securityManager.setSessionManager(sessionManager);
        return securityManager;
    }


    //创建realm对象
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    @Bean("sessionManager")
    public SessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        System.out.println("会话管理");
        List<SessionListener> listeners = new ArrayList<>();
        //需要添加自己实现的会话监听器
        listeners.add(new ShiroSessionListener());
        //添加会话监听器给sessionManager管理
        sessionManager.setSessionListeners(listeners);

        //设置会话过期时间
        sessionManager.setGlobalSessionTimeout(3*60*1000); //默认半小时
        sessionManager.setDeleteInvalidSessions(true); //默认自定调用SessionDAO的delete方法删除会话
        //设置会话定时检查
        //sessionManager.setSessionValidationInterval(180000); //默认一小时
        //sessionManager.setSessionValidationSchedulerEnabled(true);
        return sessionManager;
    }




}
