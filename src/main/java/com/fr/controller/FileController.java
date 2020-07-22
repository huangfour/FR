package com.fr.controller;

import com.fr.commom.utils.AjaxResult;
import com.fr.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
        if (imageFile==null){
            return new AjaxResult(AjaxResult.AJAX_ERROR,"文件不允许为空");
        }
        Boolean result = fileService.uploadSingleImage(imageFile);
        if (result){
            return new AjaxResult(AjaxResult.AJAX_SUCCESS,"上传成功");
        }else{
            return new AjaxResult(AjaxResult.AJAX_ERROR,"上传错误");
        }
    }

    @ApiOperation(value = "上传文件")
    @PostMapping("/uploadFile")
    public AjaxResult uploadFile(MultipartFile file) {
        if (file==null){
            return new AjaxResult(AjaxResult.AJAX_ERROR,"文件不允许为空");
        }
        Boolean result = fileService.uploadSingleFile(file);
        if (result){
            return new AjaxResult(AjaxResult.AJAX_SUCCESS,"上传成功");
        }else{
            return new AjaxResult(AjaxResult.AJAX_ERROR,"上传错误");
        }
    }

    @ApiOperation(value = "删除图片")
    @PostMapping("/deleteImage")
    public AjaxResult deleteImage(String fileUrl) {
        if (fileUrl==null){
            return new AjaxResult(AjaxResult.AJAX_ERROR,"请求参数不允许为空");
        }
        Boolean result = fileService.deletePictureStorageByFileUrl(fileUrl);
        if (result){
            return new AjaxResult(AjaxResult.AJAX_SUCCESS,"删除成功");
        }else{
            return new AjaxResult(AjaxResult.AJAX_ERROR,"删除错误");
        }
    }

    @ApiOperation(value = "删除文件")
    @PostMapping("/deleteFile")
    public AjaxResult deleteFile(String fileUrl) {
        if (fileUrl==null){
            return new AjaxResult(AjaxResult.AJAX_ERROR,"请求参数不允许为空");
        }
        Boolean result = fileService.deleteFileStorageByFileUrl(fileUrl);
        if (result){
            return new AjaxResult(AjaxResult.AJAX_SUCCESS,"删除成功");
        }else{
            return new AjaxResult(AjaxResult.AJAX_ERROR,"删除错误");
        }
    }
}
