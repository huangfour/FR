package com.fr.controller;

import com.fr.commom.utils.AjaxJsonResultWithLayUi;
import com.fr.pojo.FileStorage;
import com.fr.pojo.PictureStorage;
import com.fr.pojo.vo.FileInfoVO;
import com.fr.service.FileService;
import com.fr.service.FileStorageAttributes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : hong.Four
 * @date : 2020-07-22 10:58
 **/
@Api(value = "文件信息查看", tags = {"文件信息查看"})
@RestController
@RequestMapping("fileInfo")
public class FileInfoController {

    @Autowired
    FileService fileService;

    @Autowired
    FileStorageAttributes fileStorageAttributes;

    // TODO 将结果赋予FileInfoVO 并进行格式转换
    @ApiOperation(value = "查看图片文件信息(根据userId)")
    @GetMapping("/findImageInfo")
    public AjaxJsonResultWithLayUi findImageInfo(Integer userId) {
        if (userId==null){
            return AjaxJsonResultWithLayUi.errorMsg("文件不允许为空");
        }
        List<PictureStorage> list= fileService.findPictureStorageByUserId(userId);
        if (!list.isEmpty()){
            return AjaxJsonResultWithLayUi.ok(list);
        }else{
            return AjaxJsonResultWithLayUi.errorMsg("查询错误");
        }
    }

    // TODO 将结果赋予FileInfoVO 并进行格式转换
    @ApiOperation(value = "查看文件信息(根据userId)")
    @GetMapping("/findFileInfo")
    public AjaxJsonResultWithLayUi findFileInfo(Integer userId) {
        if (userId==null){
            return AjaxJsonResultWithLayUi.errorMsg("文件不允许为空");
        }
        List<FileStorage> list= fileService.findFileStorageByUserId(userId);
        if (!list.isEmpty()&&list!=null){
            return AjaxJsonResultWithLayUi.ok(list);
        }else{
            return AjaxJsonResultWithLayUi.errorMsg("查询错误");
        }
    }

    @ApiOperation(value = "查看所有文件信息")
    @GetMapping("/selectAllFile")
    public  AjaxJsonResultWithLayUi selectAllFile(){
        List<FileInfoVO> list= fileStorageAttributes.selectAllFile();
        if (!list.isEmpty()&&list!=null){
            return AjaxJsonResultWithLayUi.ok(list);
        }else{
            return AjaxJsonResultWithLayUi.errorMsg("查询错误");
        }

    }

}
