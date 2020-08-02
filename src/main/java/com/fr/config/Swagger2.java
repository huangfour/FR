package com.fr.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : hong.Four
 * @date : 2020-03-10 13:02
 **/
@Configuration
@EnableSwagger2
@EnableKnife4j
public class Swagger2 {


    //http://localhost:8888/swagger-ui.html
    //http://localhost:8888/doc.html
    //Swagger2配置
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)//指定Api类型为swagger2
                .apiInfo(apiInfo()).select()          //定义api文档汇总信息
                .apis(RequestHandlerSelectors
                        .basePackage("com.fr.controller"))
                .paths(PathSelectors.any()).build()
                .pathMapping("/")
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());

    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("人脸识别系统API")
                .contact(new Contact("黄章红","https://www.xxx.com","294863053@qq.com"))
                .description("API").version("0.0.1")
                .termsOfServiceUrl("sv").build();
    }


    private List<ApiKey> securitySchemes() {
        List<ApiKey> apiKeyList= new ArrayList();
        apiKeyList.add(new ApiKey("Authorization", "Authorization", "header"));
        return apiKeyList;
    }

    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContexts=new ArrayList<>();
        securityContexts.add(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
                        .build());
        return securityContexts;
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences=new ArrayList<>();
        securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
        return securityReferences;
    }
}
