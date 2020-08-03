package com.fr.commom.utils;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * @author : hong.Four
 * @date : 2020-07-24 11:02
 **/
public class DemoTest {
    public static void main(String[] args) {
        Jackson2JsonRedisSerializer jacksonSeial = new Jackson2JsonRedisSerializer(Object.class);

    }
}
