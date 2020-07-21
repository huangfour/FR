package com.fr.commom.utils;

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
import java.io.FileNotFoundException;
import java.io.IOException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UploadServiceTest {

    @Autowired
    private UploadService uploadService;

    @Test
    public void uploadImage() {
    }

    @Test
    public void uploadFile() throws IOException {
        File file = new File("C:\\Users\\four\\Desktop\\tes2.doc");
        FileInputStream input = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile("file", file.getName(), "text/plain", IOUtils.toByteArray(input));
        String url = uploadService.uploadFile(multipartFile);
        System.out.println("上传成功："+url);
        System.out.println(url);
    }

    @Test
    public void deleteFile() {
        String parm="group1/M00/00/00/rBLdpV8RMcaATxb6AAAkAPgKYvU764.doc";
        uploadService.deleteFile(parm);
    }
}