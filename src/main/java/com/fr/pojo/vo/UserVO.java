package com.fr.pojo.vo;

/**
 * @author : hong.Four
 * @date : 2020-07-26 21:57
 **/
public class UserVO{

    private Integer userId;
    private String userAccount;
    private String userPhone;
    private String userPassword;
    private String userName;
    private String userCard;
    private String recognitionUrl;
    private String userRole;

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCard() {
        return userCard;
    }

    public void setUserCard(String userCard) {
        this.userCard = userCard;
    }

    public String getRecognitionUrl() {
        return recognitionUrl;
    }

    public void setRecognitionUrl(String recognitionUrl) {
        this.recognitionUrl = recognitionUrl;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
