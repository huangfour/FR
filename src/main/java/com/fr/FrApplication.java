package com.fr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = "com.fr.mapper")
public class FrApplication {
    public static void main(String[] args) {
        SpringApplication.run(FrApplication.class, args);
    }

}
