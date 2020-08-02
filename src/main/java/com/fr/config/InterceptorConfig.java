package com.fr.config;


import com.fr.commom.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author : hong.Four
 * @date : 2020-08-02 15:40
 * 前端拦截器配置
 **/
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getUserInterceptor()).addPathPatterns("/user/login");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
    @Bean
    public LoginInterceptor getUserInterceptor(){
        return new LoginInterceptor();
    }
}
