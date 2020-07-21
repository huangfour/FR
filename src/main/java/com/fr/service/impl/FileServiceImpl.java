package com.fr.service.impl;

import java.util.Date;

import com.fr.commom.enums.UploadStyle;
import com.fr.commom.utils.UploadService;
import com.fr.mapper.FileStorageMapper;
import com.fr.mapper.FileStorageMapperCustom;
import com.fr.mapper.UploadRecordMapper;
import com.fr.pojo.FileStorage;
import com.fr.pojo.UploadRecord;
import com.fr.service.FileService;
import io.swagger.models.auth.In;
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
    FileStorageMapperCustom fileStorageMapperCustom;

    @Override
    public boolean updateSingleFile(MultipartFile file) {
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
}
