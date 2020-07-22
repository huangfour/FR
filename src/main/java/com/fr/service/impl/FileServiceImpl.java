package com.fr.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.fr.commom.enums.UploadStyle;
import com.fr.config.UploadConfig;
import com.fr.mapper.*;
import com.fr.pojo.FileStorage;
import com.fr.pojo.PictureStorage;
import com.fr.pojo.UploadRecord;
import com.fr.service.FileService;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.exception.FdfsUnsupportStorePathException;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author : hong.Four
 * @date : 2020-07-21 22:07
 **/
@Service
public class FileServiceImpl implements FileService {

    @Resource
    private FastFileStorageClient storageClient;

    @Resource
    private UploadConfig uploadConfig;

    @Autowired
    UploadRecordMapper uploadRecordMapper;

    @Autowired
    FileStorageMapper fileStorageMapper;

    @Autowired
    PictureStorageMapper pictureStorageMapper;

    @Autowired
    FileStorageMapperCustom fileStorageMapperCustom;

    @Autowired
    PictureStorageMapperCustom pictureStorageMapperCustom;

    @Override
    public boolean uploadSingleFile(MultipartFile file) {
        FileStorage fileStorage = new FileStorage();
        try {
            // 3、上传到FastDFS
            // 3.1、获取扩展名
            String extension = StringUtils.substringAfterLast(file.getOriginalFilename(), ".");
            fileStorage.setFileStyle(extension);
            // 3.2、上传
            StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), extension, null);
            // 设置文件存储参数
            fileStorage.setBaseUrl(uploadConfig.getBaseUrl());
            fileStorage.setFileUrl(storePath.getFullPath());
            fileStorage.setFileName(file.getOriginalFilename());
            fileStorage.setCreatTime(new Date());
        } catch (IOException e) {
            System.out.println("【文件上传】上传文件失败！....");
            throw new RuntimeException("【文件上传】上传文件失败！" + e.getMessage());
        }
        //将文件记录存储
        Integer fileStorageResult = fileStorageMapperCustom.insertUseGeneratedKeys(fileStorage);
        if (fileStorageResult != 1) {
            System.out.println("插入文件存储记录失败");
        }
        //创建上传记录存储实体
        UploadRecord uploadRecord = new UploadRecord();
        uploadRecord.setFileStorageId(fileStorage.getFileStorageId());
        uploadRecord.setFileUploadTime(new Date());
        uploadRecord.setFileStyle(UploadStyle.FILE.type);
        Integer uploadRecordResult = uploadRecordMapper.insert(uploadRecord);
        if (uploadRecordResult != 1) {
            System.out.println("插入文件上传记录失败");
        }
        return fileStorageResult == 1 && uploadRecordResult == 1 ? true : false;
    }

    @Override
    public boolean uploadSingleImage(MultipartFile file) {
        // 1.校验文件类型
        String contentType = file.getContentType();
        if (!uploadConfig.getAllowTypes().contains(contentType)) {
            System.out.println(contentType);
            throw new RuntimeException("文件类型不支持");
        }
        PictureStorage pictureStorage = new PictureStorage();
        try {
            // 3、上传到FastDFS
            // 3.1、获取扩展名
            String extension = StringUtils.substringAfterLast(file.getOriginalFilename(), ".");
            pictureStorage.setPictureStyle(extension);
            // 3.2、上传
            StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), extension, null);
            // 设置文件存储参数
            pictureStorage.setBaseUrl(uploadConfig.getBaseUrl());
            pictureStorage.setPictureUrl(storePath.getFullPath());
            pictureStorage.setPictureName(file.getOriginalFilename());
            pictureStorage.setCreatTime(new Date());
        } catch (IOException e) {
            System.out.println("【文件上传】上传文件失败！....");
            throw new RuntimeException("【文件上传】上传文件失败！" + e.getMessage());
        }
        //将文件记录存储
        Integer imageStorageResult = pictureStorageMapperCustom.insertUseGeneratedKeys(pictureStorage);
        if (imageStorageResult != 1) {
            System.out.println("插入文件存储记录失败");
        }
        //创建上传记录存储实体
        UploadRecord uploadRecord = new UploadRecord();
        uploadRecord.setFileStorageId(pictureStorage.getPictureStorageId());
        uploadRecord.setFileUploadTime(new Date());
        uploadRecord.setFileStyle(UploadStyle.FILE.type);
        Integer uploadRecordResult = uploadRecordMapper.insert(uploadRecord);
        if (uploadRecordResult != 1) {
            System.out.println("插入文件上传记录失败");
        }
        return imageStorageResult == 1 && uploadRecordResult == 1 ? true : false;
    }

    @Override
    public List<FileStorage> findFileStorageByUserId(Integer id) {
        if (id == null) {
            System.out.println("用户ID为空");
            return null;
        } else {
            FileStorage fileStorage = new FileStorage();
            fileStorage.setUserId(id);
            List<FileStorage> list = fileStorageMapper.select(fileStorage);
            if (list != null && !list.isEmpty()) {
                //list存在且里面有元素
                return list;
            } else {
                System.out.println("不存在该UserId的文件");
                return null;
            }
        }
    }

    @Override
    public List<PictureStorage> findPictureStorageByUserId(Integer id) {
        if (id == null) {
            System.out.println("用户ID为空");
            return null;
        } else {
            PictureStorage pictureStorage = new PictureStorage();
            pictureStorage.setUserId(id);
            List<PictureStorage> list = pictureStorageMapper.select(pictureStorage);
            if (list != null && !list.isEmpty()) {
                //list存在且里面有元素
                return list;
            } else {
                System.out.println("不存在该UserId的图片");
                return null;
            }
        }

    }

    @Override
    public boolean deleteFileStorageByFileUrl(String fileUrl) {
        if (StringUtils.isEmpty(fileUrl)) {
            return false;
        }
        try {
            StorePath storePath = StorePath.parseFromUrl(fileUrl);
            storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
        } catch (FdfsUnsupportStorePathException e) {

        }
        FileStorage fileStorage = new FileStorage();
        fileStorage.setFileUrl(fileUrl);
        Integer result = fileStorageMapper.delete(fileStorage);
        return result == 1 ? true : false;
    }

    @Override
    public boolean deletePictureStorageByFileUrl(String fileUrl) {
        if (StringUtils.isEmpty(fileUrl)) {
            return false;
        }
        try {
            StorePath storePath = StorePath.parseFromUrl(fileUrl);
            storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
        } catch (FdfsUnsupportStorePathException e) {
        }
        PictureStorage pictureStorage = new PictureStorage();
        pictureStorage.setPictureUrl(fileUrl);
        Integer result = pictureStorageMapper.delete(pictureStorage);
        return result == 1 ? true : false;
    }
}
