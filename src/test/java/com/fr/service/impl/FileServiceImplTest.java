package com.fr.service.impl;

import com.fr.service.FileService;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileServiceImplTest {

    @Autowired
    FileService fileService;
    @Test
    public void updateSingleFile() throws IOException {
        File file = new File("C:\\Users\\four\\Desktop\\tes2.doc");
        FileInputStream input = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile("file", file.getName(), "text/plain", IOUtils.toByteArray(input));
        fileService.uploadSingleFile(multipartFile);
    }
    @Test
    public void uploadSingleImage() throws IOException {
        File file = new File("C:\\Users\\four\\Desktop\\2-19 通用Mapper接口所封装的常用方法.jpg");
        FileInputStream input = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile("file", file.getName(), "image/jpeg", IOUtils.toByteArray(input));
        fileService.uploadSingleImage(multipartFile);

    }
}