package com.fr.service;

import com.fr.pojo.User;
import com.fr.pojo.bo.UserBO;
import com.fr.pojo.vo.UserVO;

import java.util.List;

/**
 * @author : hong.Four
 * @date : 2020-07-26 21:54
 **/
public interface UserService {

    /**
     * 用户注册
     * @return
     */
    public User userRegistered(UserBO user);

    /**
     * 根据电话查找密码
     * @param userPhone
     * @return
     */
    public String selectPasswordByUserPhone(String userPhone);

    /**
     * 根据电话查询用户
     * @param userPhone
     * @return
     */
    public User selectUserByUserPhone(String userPhone);

    /**
     * 查询所有用户
     * @return
     */
    public List<UserVO> selectAllUser();



}
