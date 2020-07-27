package com.fr.service.impl;

import java.util.Date;
import java.util.HashMap;


import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.fr.commom.faceUtil.FaceConfig;
import com.fr.commom.faceUtil.FaceResultBo;
import com.fr.config.UploadConfig;
import com.fr.mapper.RecognitionMapper;
import com.fr.mapper.RecognitionMapperCustom;
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
    @Autowired
    RecognitionMapperCustom recognitionMapperCustom;
    @Autowired
    UploadConfig uploadConfig;


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
        UploadFileResultBO uploadFileResultBO1 = new UploadFileResultBO();
        uploadFileResultBO1.setUrl(uploadFileResultBO.getUrl());
        return uploadFileResultBO1;
    }

    @Override
    public String faceRecognition(MultipartFile file) {
        // 1.校验文件类型
        String contentType = file.getContentType();
        if (!uploadConfig.getAllowTypes().contains(contentType)) {
            System.out.println(contentType);
            throw new RuntimeException("文件类型不支持");
        }
        //上传人脸图片
        UploadFileResultBO uploadFileResultBO = fileService.uploadSingleImage(file);
        //查询出数据库当中用户人脸URL
        //从会话管理当中获取用户ID
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Integer userId = Integer.parseInt(session.getAttribute("userId").toString());
        String Url = recognitionMapperCustom.queryUserRecognitionByUserId(userId + "");

        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("api_key", FaceConfig.API_KEY);
        paramMap.put("api_secret", FaceConfig.API_SECRET);
        paramMap.put("image_url1", Url);
        paramMap.put("image_url2", uploadFileResultBO.getUrl());
        String result = HttpUtil.post(FaceConfig.URL, paramMap);
        FaceResultBo faceResultBo = JSONObject.parseObject(result, FaceResultBo.class);
        //下载文件
        return faceResultBo.getConfidence() + "";
    }
}
