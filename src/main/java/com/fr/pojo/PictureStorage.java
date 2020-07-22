package com.fr.pojo;

import java.util.Date;
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

    @Column(name = "base_url")
    private String baseUrl;

    @Column(name = "picture_name")
    private String pictureName;

    @Column(name = "picture_style")
    private String pictureStyle;

    @Column(name = "creat_time")
    private Date creatTime;

    @Column(name = "picture_size")
    private String pictureSize;

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
     * @return picture_name
     */
    public String getPictureName() {
        return pictureName;
    }

    /**
     * @param pictureName
     */
    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    /**
     * @return picture_style
     */
    public String getPictureStyle() {
        return pictureStyle;
    }

    /**
     * @param pictureStyle
     */
    public void setPictureStyle(String pictureStyle) {
        this.pictureStyle = pictureStyle;
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

    public String getPictureSize() {
        return pictureSize;
    }

    public void setPictureSize(String pictureSize) {
        this.pictureSize = pictureSize;
    }
}