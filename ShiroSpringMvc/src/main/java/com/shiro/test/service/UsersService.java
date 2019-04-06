package com.shiro.test.service;

import com.shiro.test.pojo.Users;

/**
 * Created by wang on 2019/3/24.
 */
public interface UsersService {
    Users getUserByEmail(String email);

    Users doLogin(String email,String password);
}
