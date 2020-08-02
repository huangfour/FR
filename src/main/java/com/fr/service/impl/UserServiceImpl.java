package com.fr.service.impl;

import com.fr.mapper.RecognitionMapper;
import com.fr.mapper.RecognitionMapperCustom;
import com.fr.mapper.UserMapper;
import com.fr.pojo.User;
import com.fr.pojo.bo.UserBO;
import com.fr.pojo.vo.UserVO;
import com.fr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : hong.Four
 * @date : 2020-07-26 21:54
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    RecognitionMapperCustom recognitionMapperCustom;

    @Override
    public User userRegistered(UserBO user) {
        Boolean result;
        if (user != null) {
            result = queryUserPhoneIsExist(user.getUserPhone());
            if (!result) {
                User user1 = new User();
                user1.setUserName("");
                user1.setUserCard("");
                user1.setUserPhone(user.getUserPhone());
                user1.setUserAccount("");
                user1.setUserPassword(user.getUserPassword());
                user1.setUserRole("");
                userMapper.insert(user1);
                return user1;
            }
        }
        return null;
    }


    @Override
    public String selectPasswordByUserPhone(String userPhone) {
        Example userExample = new Example(User.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEqualTo("userPhone", userPhone);
        User result = userMapper.selectOneByExample(userExample);
        return result.getUserPassword();
    }

    @Override
    public User selectUserByUserPhone(String userPhone) {
        Example userExample = new Example(User.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEqualTo("userPhone", userPhone);
        User result = userMapper.selectOneByExample(userExample);
        return result;
    }

    @Override
    public List<UserVO> selectAllUser() {
        List<User> list = userMapper.selectAll();
        List<UserVO> list1=new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            User user=list.get(i);
            user.setUserPassword("");

            UserVO userVO=new UserVO();
            userVO.setUserAccount(list.get(i).getUserAccount());
            userVO.setUserPhone(list.get(i).getUserPhone());
            userVO.setUserPassword(list.get(i).getUserPassword());
            userVO.setUserName(list.get(i).getUserName());
            userVO.setUserCard(list.get(i).getUserCard());
            userVO.setUserId(list.get(i).getUserId());
            userVO.setUserRole(list.get(i).getUserRole());
            userVO.setRecognitionUrl(queryUserRecognitionUrlByUserId(list.get(i).getUserId()+""));
            list1.add(userVO);
        }
        return list1;
    }
    public String queryUserRecognitionUrlByUserId(String userId){
        String url=recognitionMapperCustom.queryUserRecognitionByUserId(userId);
        if (url==null){
            return null;
        }
        return url;
    }


    public boolean queryUserPhoneIsExist(String userPhone) {
        Example userExample = new Example(User.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEqualTo("userPhone", userPhone);
        User result = userMapper.selectOneByExample(userExample);
        return result == null ? false : true;
    }
}
