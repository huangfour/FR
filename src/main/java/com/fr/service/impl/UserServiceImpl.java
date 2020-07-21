package com.fr.service.impl;

import com.fr.mapper.UserMapper;
import com.fr.pojo.User;
import com.fr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : hong.Four
 * @date : 2020-07-21 08:16
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> findAll() {
        List<User> list = userMapper.selectAll();
        return list;
    }
}
