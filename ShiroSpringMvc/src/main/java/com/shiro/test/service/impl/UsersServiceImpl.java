package com.shiro.test.service.impl;

import com.shiro.test.mapper.UsersMapper;
import com.shiro.test.pojo.Users;
import com.shiro.test.service.UsersService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wang on 2019/3/24.
 */
@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersMapper um;

    @Override
    public Users getUserByEmail(String email) {
        return um.getUserByEmail(email);
    }

    @Override
    public Users doLogin(String email, String password) {
        Subject sub = SecurityUtils.getSubject();
        UsernamePasswordToken token =
                new UsernamePasswordToken(email,password);
        try {
            sub.login(token);
            Session session = sub.getSession();
            Users user = getUserByEmail(email);
            session.setAttribute("session_user",user);
            return user;
        } catch (AuthenticationException e) {
            return null;
        }
    }
}
