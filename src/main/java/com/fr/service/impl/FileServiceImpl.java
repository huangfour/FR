package com.fr.service.impl;

import java.util.Date;
import java.util.List;

import com.fr.commom.enums.UploadStyle;
import com.fr.commom.utils.UploadService;
import com.fr.mapper.*;
import com.fr.pojo.FileStorage;
import com.fr.pojo.PictureStorage;
import com.fr.pojo.UploadRecord;
import com.fr.service.FileService;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author : hong.Four
 * @date : 2020-07-21 22:07
 **/
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    UploadService uploadService;

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
        //上传文件
        String fileFullPath = uploadService.uploadFile(file);
        //创建文件存储实体
        FileStorage fileStorage = new FileStorage();
        fileStorage.setFileUrl(fileFullPath);
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
        //上传图片类型文件
        String fileFullPath = uploadService.uploadImage(file);
        //创建文件存储实体
        PictureStorage pictureStorage = new PictureStorage();
        pictureStorage.setPictureUrl(fileFullPath);
        Integer pictureStorageResult = pictureStorageMapperCustom.insertUseGeneratedKeys(pictureStorage);
        if (pictureStorageResult != 1) {
            System.out.println("插入图片存储记录失败");
        }
        //创建上传记录存储实体
        UploadRecord uploadRecord = new UploadRecord();
        uploadRecord.setFileStorageId(pictureStorage.getPictureStorageId());
        uploadRecord.setFileUploadTime(new Date());
        uploadRecord.setFileStyle(UploadStyle.IMAGE.type);
        Integer uploadRecordResult = uploadRecordMapper.insert(uploadRecord);
        if (uploadRecordResult != 1) {
            System.out.println("插入图片上传记录失败");
        }
        return pictureStorageResult == 1 && uploadRecordResult == 1 ? true : false;
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
        uploadService.deleteFile(fileUrl);
        FileStorage fileStorage = new FileStorage();
        fileStorage.setFileUrl(fileUrl);
        Integer result = fileStorageMapper.delete(fileStorage);
        return result == 1 ? true : false;
    }

    @Override
    public boolean deletePictureStorageByFileUrl(String fileUrl) {
        uploadService.deleteFile(fileUrl);
        PictureStorage pictureStorage = new PictureStorage();
        pictureStorage.setPictureUrl(fileUrl);
        Integer result = pictureStorageMapper.delete(pictureStorage);
        return result == 1 ? true : false;
    }
}
