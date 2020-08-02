package com.fr.pojo;

import javax.persistence.*;
import java.io.Serializable;

public class User implements Serializable {
    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_card")
    private String userCard;

    @Column(name = "user_phone")
    private String userPhone;

    @Column(name = "user_account")
    private String userAccount;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_role")
    private String userRole;

    @Column(name = "user_recognition")
    private Integer userRecognition;

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
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return user_card
     */
    public String getUserCard() {
        return userCard;
    }

    /**
     * @param userCard
     */
    public void setUserCard(String userCard) {
        this.userCard = userCard;
    }

    /**
     * @return user_phone
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * @param userPhone
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * @return user_account
     */
    public String getUserAccount() {
        return userAccount;
    }

    /**
     * @param userAccount
     */
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    /**
     * @return user_password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @param userPassword
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * @return user_role
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * @param userRole
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /**
     * @return user_recognition
     */
    public Integer getUserRecognition() {
        return userRecognition;
    }

    /**
     * @param userRecognition
     */
    public void setUserRecognition(Integer userRecognition) {
        this.userRecognition = userRecognition;
    }
}