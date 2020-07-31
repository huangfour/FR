package com.fr.commom.shiro;

import com.fr.mapper.UserMapper;
import com.fr.pojo.User;
import com.fr.service.UserService;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : hong.Four
 * @date : 2020-07-27 11:09
 **/
@Component
public class ShiroSessionListener implements SessionListener {

    private final AtomicInteger sessionCount = new AtomicInteger(0);

    @Override
    public void onStart(Session session) {
        sessionCount.incrementAndGet();
        System.out.println("sessionId为"+session.getId());
        System.out.println("登陆+1  总数为：" + sessionCount.get());

    }

    @Override
    public void onStop(Session session) {
        sessionCount.decrementAndGet();
        System.out.println("登陆-1  总数为：" + sessionCount.get());
    }

    @Override
    public void onExpiration(Session session) {
        sessionCount.decrementAndGet();
        System.out.println("登陆过期-1  总数为：" + sessionCount.get());
    }

}