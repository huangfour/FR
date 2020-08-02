package com.fr.commom.jwt;

import org.junit.Test;

import static org.junit.Assert.*;

public class TokenUtilTest {


    @Test
    public void sign() {
        Long currentTimeMillis = System.currentTimeMillis();
        String token= TokenUtil.sign("15575775583",77,currentTimeMillis);
        System.out.println(TokenUtil.getUserId(token));
    }

    @Test
    public void verify() throws Exception {
        TokenUtil.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjdXJyZW50VGltZSI6MTU5NjExODY0NDQ5MiwiaXNzIjoiYXV0aDAiLCJleHAiOjE1OTYxMTg5NDQsImFjY291bnQiOiIxNTU3NTc3NTU4MyJ9.nSE1Pyk-KCfvgdz97bUXnZltd62lmiCab07C9kd0aHY");
    }

    @Test
    public void getAccount() {

    }

    @Test
    public void getCurrentTime() {
    }
}