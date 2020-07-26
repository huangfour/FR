package com.fr.pojo.vo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author : hong.Four
 * @date : 2020-07-22 14:37
 * 文件详细信息
 **/
public class FileInfoVO {

    private Integer fileStorageId;

    private Integer userId;

    private String fileUrl;

    private String baseUrl;

    private String fileName;

    private String fileStyle;

    private Date creatTime;

    private String fileSize;

    private Integer style;

    public Integer getFileStorageId() {
        return fileStorageId;
    }

    public void setFileStorageId(Integer fileStorageId) {
        this.fileStorageId = fileStorageId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileStyle() {
        return fileStyle;
    }

    public void setFileStyle(String fileStyle) {
        this.fileStyle = fileStyle;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public Integer getStyle() {
        return style;
    }

    public void setStyle(Integer style) {
        this.style = style;
    }
}
