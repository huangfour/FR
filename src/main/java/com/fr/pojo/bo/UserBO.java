package com.fr.pojo.bo;

import javax.persistence.Column;

/**
 * @author : hong.Four
 * @date : 2020-07-26 21:59
 **/
public class UserBO {

    private String userAccount;
    private String userPhone;
    private String userPassword;


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
}
