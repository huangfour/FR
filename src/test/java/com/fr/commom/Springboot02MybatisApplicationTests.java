package com.fr.commom;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



/**
 * @author : hong.Four
 * @date : 2020-08-03 23:09
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot02MybatisApplicationTests {

    private final Logger logger = LoggerFactory.getLogger(Springboot02MybatisApplicationTests.class);
    @Test
    public void contextLoads() {
        logger.info("数据库日志info");
        logger.error("数据库日志error");
    }
}