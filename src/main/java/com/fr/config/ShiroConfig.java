package com.fr.config;

import com.fr.commom.jwt.JWTFilter;
import com.fr.commom.shiro.CustomRealm;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
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

        Map<String, Filter> filtersMap = new LinkedHashMap<>();
        filtersMap.put("jwt", new JWTFilter());
        bean.setFilters(filtersMap);

        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        //添加Shiro的内置过滤器
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/user/login", "anon");
        filterMap.put("/user/registered", "anon");



//        filterMap.put("/**", "anon"); //认证
        filterMap.put("/**", "jwt"); //认证
        bean.setFilterChainDefinitionMap(filterMap);
        return bean;
    }

    //DefaultWebSecurityManager
    @Bean(name = "securityManage")
    public DefaultWebSecurityManager getDefaultWebSecurityManage(CustomRealm customRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(customRealm);
//        securityManager.setSessionManager(sessionManager);
        //关闭自带的session管理
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        securityManager.setSubjectDAO(subjectDAO);
        return securityManager;
    }


//    @Bean("sessionManager")
//    public SessionManager sessionManager() {
//        DefaultWebSessionManager sessionManager = new ShiroSession();
//        System.out.println("会话管理");
//        List<SessionListener> listeners = new ArrayList<>();
//        //需要添加自己实现的会话监听器
//        listeners.add(new ShiroSessionListener());
//        //添加会话监听器给sessionManager管理
//        sessionManager.setSessionListeners(listeners);
//        //设置会话过期时间
//        sessionManager.setGlobalSessionTimeout(3*60*1000); //默认半小时
//        sessionManager.setDeleteInvalidSessions(true); //默认自定调用SessionDAO的delete方法删除会话
//
//        return sessionManager;
//    }


}
