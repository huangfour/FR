package com.fr.service;

import com.fr.pojo.bo.UploadFileResultBO;
import org.springframework.web.multipart.MultipartFile;

import java.lang.management.MemoryUsage;

/**
 * @author : hong.Four
 * @date : 2020-07-27 10:34
 **/
public interface FaceService {

    /**
     * 上传人脸图片信息
     * @return
     */
    public UploadFileResultBO uploadFaceImage(MultipartFile file);

    /**
     * 人脸识别
     * @return
     */
    public Boolean faceRecognition();

}
