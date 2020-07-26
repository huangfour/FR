package com.fr.commom.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author : hong.Four
 * @date : 2020-07-24 11:02
 **/
public class DemoTest {
    public static void main(String[] args) {
        String password = "123456";
        String salt = "wjw";//盐
        Integer hashIterations = 2;//散列次数
        //3.加盐再设置散列次数的md5
        Md5Hash md5 = new Md5Hash(password, salt, hashIterations);
        System.out.println(md5.toString());

    }
}
