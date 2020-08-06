package com.fr.service.impl;

import com.fr.service.FileStorageAttributes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class FileStorageAttributesImplTest {

    @Autowired
    FileStorageAttributes fileStorageAttributes;

    @Test
    public void listGroups() {
        System.out.println(fileStorageAttributes.listGroups().get(0).getStorageCount());

    }
}