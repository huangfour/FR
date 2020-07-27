package com.fr.pojo;

import java.util.Date;
import javax.persistence.*;

public class Recognition {
    @Id
    @Column(name = "user_recognition_id")
    private Integer userRecognitionId;

    @Column(name = "userId")
    private Integer userid;

    @Column(name = "recognition_url")
    private String recognitionUrl;

    @Column(name = "recognition_url_list")
    private String recognitionUrlList;

    @Column(name = "other_param")
    private Integer otherParam;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return user_recognition_id
     */
    public Integer getUserRecognitionId() {
        return userRecognitionId;
    }

    /**
     * @param userRecognitionId
     */
    public void setUserRecognitionId(Integer userRecognitionId) {
        this.userRecognitionId = userRecognitionId;
    }

    /**
     * @return userId
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * @return recognition_url
     */
    public String getRecognitionUrl() {
        return recognitionUrl;
    }

    /**
     * @param recognitionUrl
     */
    public void setRecognitionUrl(String recognitionUrl) {
        this.recognitionUrl = recognitionUrl;
    }

    /**
     * @return recognition_url_list
     */
    public String getRecognitionUrlList() {
        return recognitionUrlList;
    }

    /**
     * @param recognitionUrlList
     */
    public void setRecognitionUrlList(String recognitionUrlList) {
        this.recognitionUrlList = recognitionUrlList;
    }

    /**
     * @return other_param
     */
    public Integer getOtherParam() {
        return otherParam;
    }

    /**
     * @param otherParam
     */
    public void setOtherParam(Integer otherParam) {
        this.otherParam = otherParam;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}