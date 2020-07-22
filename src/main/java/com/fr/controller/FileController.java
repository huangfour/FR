package com.fr.controller;

import com.fr.commom.utils.AjaxResult;
import com.fr.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
        Boolean result = fileService.uploadSingleImage(imageFile);
        if (result) {
            return new AjaxResult(AjaxResult.AJAX_SUCCESS, "上传成功");
        } else {
            return new AjaxResult(AjaxResult.AJAX_ERROR, "上传错误");
        }
    }
//
//    @ApiOperation(value = "上传多张图片")
//    @PostMapping("/uploadMultiImage")
//    public AjaxResult uploadMultiImage(List<MultipartFile> imageFile) {
//        List<String> failList = new ArrayList<>();
//        for (int i = 0; i < imageFile.size(); i++) {
//            if (imageFile.get(i) == null) {
//                return new AjaxResult(AjaxResult.AJAX_ERROR, "文件不允许为空");
//            }
//        }
//        for (int i = 0; i < imageFile.size(); i++) {
//            Boolean result = fileService.uploadSingleImage(imageFile.get(i));
//            if (!result) {
//                failList.add(imageFile.get(i).getOriginalFilename());
//            }
//        }
//        if (failList.size() == 0) {
//            return new AjaxResult(AjaxResult.AJAX_SUCCESS, "上传成功");
//        } else {
//            return new AjaxResult(AjaxResult.AJAX_SUCCESS, "上传部分失败");
//        }
//    }

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
}
