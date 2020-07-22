package com.fr.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "file_storage")
public class FileStorage {
    @Id
    @Column(name = "file_storage_id")
    private Integer fileStorageId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "file_url")
    private String fileUrl;

    @Column(name = "base_url")
    private String baseUrl;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_style")
    private String fileStyle;

    @Column(name = "creat_time")
    private Date creatTime;

    /**
     * @return file_storage_id
     */
    public Integer getFileStorageId() {
        return fileStorageId;
    }

    /**
     * @param fileStorageId
     */
    public void setFileStorageId(Integer fileStorageId) {
        this.fileStorageId = fileStorageId;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return file_url
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * @param fileUrl
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    /**
     * @return base_url
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * @param baseUrl
     */
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     * @return file_name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return file_style
     */
    public String getFileStyle() {
        return fileStyle;
    }

    /**
     * @param fileStyle
     */
    public void setFileStyle(String fileStyle) {
        this.fileStyle = fileStyle;
    }

    /**
     * @return creat_time
     */
    public Date getCreatTime() {
        return creatTime;
    }

    /**
     * @param creatTime
     */
    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}