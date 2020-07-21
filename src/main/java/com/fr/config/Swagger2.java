package com.fr.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

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
                .paths(PathSelectors.any()).build();

    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("人脸识别系统API")
                .contact(new Contact("黄章红","https://www.xxx.com","294863053@qq.com"))
                .description("API").version("0.0.1")
                .termsOfServiceUrl("sv").build();
    }
}
