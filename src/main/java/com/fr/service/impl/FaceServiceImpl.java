package com.fr.service.impl;

import java.util.Date;


import com.fr.mapper.RecognitionMapper;
import com.fr.pojo.Recognition;
import com.fr.pojo.bo.UploadFileResultBO;
import com.fr.service.FaceService;
import com.fr.service.FileService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author : hong.Four
 * @date : 2020-07-27 10:39
 **/
@Service
public class FaceServiceImpl implements FaceService {

    @Autowired
    FileService fileService;
    @Autowired
    RecognitionMapper recognitionMapper;

    @Override
    public UploadFileResultBO uploadFaceImage(MultipartFile file) {
        //上传用户图片
        UploadFileResultBO uploadFileResultBO = fileService.uploadSingleImage(file);
        //将文件记录存储在表当中
        Recognition recognition = new Recognition();
        //从会话管理当中获取用户ID
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Integer userId = Integer.parseInt(session.getAttribute("userId").toString());
        recognition.setUserid(userId);
        recognition.setRecognitionUrl(uploadFileResultBO.getUrl());
        recognition.setCreateTime(new Date());

        recognitionMapper.insert(recognition);
        UploadFileResultBO uploadFileResultBO1=new UploadFileResultBO();
        uploadFileResultBO1.setUrl(uploadFileResultBO.getUrl());
        return uploadFileResultBO1;
    }

    @Override
    public Boolean faceRecognition() {
        return null;
    }
}
