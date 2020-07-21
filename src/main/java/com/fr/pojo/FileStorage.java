package com.fr.pojo;

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
}