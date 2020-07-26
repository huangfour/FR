package com.fr.service.impl;

import com.fr.pojo.bo.UploadFileResultBO;
import com.fr.service.FileService;
import com.github.tobato.fastdfs.domain.fdfs.MetaData;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.DefaultGenerateStorageClient;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.github.tobato.fastdfs.service.GenerateStorageClient;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileServiceImplTest {

    @Autowired
    FileService fileService;
    @Resource
    private FastFileStorageClient storageClient;
    @Resource
    private DefaultGenerateStorageClient defaultGenerateStorageClient;




    @Test
    public void updateSingleFile() throws IOException {
        File file = new File("C:\\Users\\four\\Desktop\\新建 DOCX 文档.docx");
        FileInputStream input = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile("file", file.getName(), "text/plain", IOUtils.toByteArray(input));
        fileService.uploadSingleFile(multipartFile);
    }

    @Test
    public void uploadSingleImage() throws IOException {
        File file = new File("C:\\Users\\four\\Desktop\\123.jpg");
        FileInputStream input = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile("file", file.getName(), "image/jpeg", IOUtils.toByteArray(input));
        fileService.uploadSingleImage(multipartFile);

    }

    @Test
    public void uploadImageAndCrtThumbImage() throws IOException {
        File file = new File("C:\\Users\\four\\Desktop\\123.jpg");
        FileInputStream input = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile("file", file.getName(), "image/jpeg", IOUtils.toByteArray(input));
        Set<MetaData> metaDataSet = new HashSet<>();
        StorePath s = storageClient.uploadImageAndCrtThumbImage(input, multipartFile.getSize(), "JPG", metaDataSet);
        System.out.println(s.toString());
    }

    @Test
    public void deletePictureStorageByFileUrl() throws IOException {

        fileService.deletePictureStorageByFileUrl("group1/M00/00/00/rBLdpV8X11OAfegeAAA52evGVgA200.jpg");

    }


    @Test
    public void downloadFile() {
        String url="group1/M00/00/00/rBLdpV8dHCGAR1Q3AABt9WLqiVA284.jpg";
        callback callback=new callback();
        StorePath path=StorePath.parseFromUrl(url);
        UploadFileResultBO uploadFileResultBO= (UploadFileResultBO) defaultGenerateStorageClient.downloadFile(path.getGroup(),path.getPath(),callback);
        System.out.println(uploadFileResultBO.getUrl());

    }

    @Test
    public void downloadFile_() {
        String url="group1/M00/00/00/rBLdpV8dHCGAR1Q3AABt9WLqiVA284.jpg";
        fileService.downloadImage(url);


    }




}