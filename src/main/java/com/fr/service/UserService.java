package com.fr.service;

import com.fr.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : hong.Four
 * @date : 2020-07-21 08:15
 **/
public interface UserService {

    public List<User> findAll();
}
