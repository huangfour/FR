package com.fr.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "upload_record")
public class UploadRecord {
    @Id
    @Column(name = "file_upload_id")
    private Integer fileUploadId;

    @Column(name = "file_storage_id")
    private Integer fileStorageId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "file_upload_time")
    private Date fileUploadTime;

    @Column(name = "file_style")
    private Integer fileStyle;

    /**
     * @return file_upload_id
     */
    public Integer getFileUploadId() {
        return fileUploadId;
    }

    /**
     * @param fileUploadId
     */
    public void setFileUploadId(Integer fileUploadId) {
        this.fileUploadId = fileUploadId;
    }

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
     * @return file_upload_time
     */
    public Date getFileUploadTime() {
        return fileUploadTime;
    }

    /**
     * @param fileUploadTime
     */
    public void setFileUploadTime(Date fileUploadTime) {
        this.fileUploadTime = fileUploadTime;
    }

    /**
     * @return file_style
     */
    public Integer getFileStyle() {
        return fileStyle;
    }

    /**
     * @param fileStyle
     */
    public void setFileStyle(Integer fileStyle) {
        this.fileStyle = fileStyle;
    }
}