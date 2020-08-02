package com.fr.controller;

import com.fr.commom.utils.AjaxJsonResultWithLayUi;
import com.fr.commom.utils.AjaxResult;
import com.fr.pojo.bo.UploadFileResultBO;
import com.fr.service.FaceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author : hong.Four
 * @date : 2020-07-27 17:47
 **/
@Api(value = "人脸识别", tags = {"人脸识别"})
@RestController
@RequestMapping("face")
public class FaceController {

    @Autowired
    FaceService faceService;

    @ApiOperation(value = "上传人脸图片")
    @PostMapping("/uploadFaceImage")
    public AjaxResult uploadFaceImage(MultipartFile file) {
        UploadFileResultBO uploadFileResultBO = faceService.uploadFaceImage(file);
        return AjaxResult.OK(uploadFileResultBO);
    }

    @ApiOperation(value = "人脸识别")
    @PostMapping("/faceRecognition")
    public AjaxResult faceRecognition(MultipartFile file) {
        String result = faceService.faceRecognition(file);
        if (result==null){
            return AjaxResult.ERROR("查询错误");
        }
        return AjaxResult.OK("请求成功",result);
    }
}
