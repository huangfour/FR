package com.fr.pojo;

import javax.persistence.*;

@Table(name = "picture_storage")
public class PictureStorage {
    @Id
    @Column(name = "picture_storage_id")
    private Integer pictureStorageId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "picture_url")
    private String pictureUrl;

    /**
     * @return picture_storage_id
     */
    public Integer getPictureStorageId() {
        return pictureStorageId;
    }

    /**
     * @param pictureStorageId
     */
    public void setPictureStorageId(Integer pictureStorageId) {
        this.pictureStorageId = pictureStorageId;
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
     * @return picture_url
     */
    public String getPictureUrl() {
        return pictureUrl;
    }

    /**
     * @param pictureUrl
     */
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}