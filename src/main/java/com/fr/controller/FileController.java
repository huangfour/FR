package com.fr.controller;

import com.fr.commom.utils.AjaxResult;
import com.fr.pojo.bo.UploadFileResultBO;
import com.fr.pojo.vo.UploadFileResultVO;
import com.fr.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : hong.Four
 * @date : 2020-07-15 21:40
 * 文件管理控制类
 **/
@Api(value = "文件上传", tags = {"文件操作"})
@RestController
@RequestMapping("file")
public class FileController {

    @Autowired
    FileService fileService;

    @ApiOperation(value = "上传图片")
    @PostMapping("/uploadImage")
    public AjaxResult uploadImage(MultipartFile imageFile) {
        if (imageFile == null) {
            return new AjaxResult(AjaxResult.AJAX_ERROR, "文件不允许为空");
        }

        UploadFileResultBO result = fileService.uploadSingleImage(imageFile);
        if (result != null) {
            UploadFileResultVO resultVO = new UploadFileResultVO();
            resultVO.setUrl(result.getUrl());
            return new AjaxResult(AjaxResult.AJAX_SUCCESS, "上传成功", result);
        } else {
            return new AjaxResult(AjaxResult.AJAX_ERROR, "上传错误");
        }
    }


    @ApiOperation(value = "上传文件")
    @PostMapping("/uploadFile")
    public AjaxResult uploadFile(MultipartFile file) {
        if (file == null) {
            return new AjaxResult(AjaxResult.AJAX_ERROR, "文件不允许为空");
        }
        Boolean result = fileService.uploadSingleFile(file);
        if (result) {
            return new AjaxResult(AjaxResult.AJAX_SUCCESS, "上传成功");
        } else {
            return new AjaxResult(AjaxResult.AJAX_ERROR, "上传错误");
        }
    }

    @ApiOperation(value = "删除图片")
    @GetMapping("/deleteImage")
    public AjaxResult deleteImage(String fileUrl) {
        if (fileUrl == null) {
            return new AjaxResult(AjaxResult.AJAX_ERROR, "请求参数不允许为空");
        }
        Boolean result = fileService.deletePictureStorageByFileUrl(fileUrl);
        if (result) {
            return new AjaxResult(AjaxResult.AJAX_SUCCESS, "删除成功");
        } else {
            return new AjaxResult(AjaxResult.AJAX_ERROR, "删除错误");
        }
    }

    @ApiOperation(value = "删除文件")
    @GetMapping("/deleteFile")
    public AjaxResult deleteFile(String fileUrl) {
        System.out.println(fileUrl);
        if (fileUrl == null) {
            return new AjaxResult(AjaxResult.AJAX_ERROR, "请求参数不允许为空");
        }
        Boolean result = fileService.deleteFileStorageByFileUrl(fileUrl);
        if (result) {
            return new AjaxResult(AjaxResult.AJAX_SUCCESS, "删除成功");
        } else {
            return new AjaxResult(AjaxResult.AJAX_ERROR, "删除错误");
        }
    }

    @ApiOperation(value = "下载图片")
    @PostMapping("/downloadImage")
    public ResponseEntity<byte[]> imageDownload(String filename,String fileUrl) throws IOException {
        HttpHeaders httpHeaders = new HttpHeaders();
        File file = fileService.downloadImage(fileUrl);
        httpHeaders.setContentDispositionFormData("attachment", filename);
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), httpHeaders, HttpStatus.OK);
    }
}
