package com.fr.service.impl;

import com.fr.mapper.RecognitionMapperCustom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    RecognitionMapperCustom recognitionMapperCustom;

    @Test
    public void queryUserRecognitionUrlByUserId() {
        String userId = "2";
        String s = recognitionMapperCustom.queryUserRecognitionByUserId(userId);
        System.out.println(s);
    }
}