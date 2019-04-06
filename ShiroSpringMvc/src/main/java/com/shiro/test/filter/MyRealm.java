package com.shiro.test.filter;

import com.shiro.test.pojo.Users;
import com.shiro.test.service.UsersService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wang on 2019/3/24.
 */
public class MyRealm extends AuthorizingRealm{

    @Autowired
    private UsersService us;

    //每次验证权限时执行的
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
    //登陆执行
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String name = (String) authenticationToken.getPrincipal();
        Users user = us.getUserByEmail(name);
        if(user != null){
            return new SimpleAuthenticationInfo(name,user.getPassword(),
                    null,getName());
        }

        return null;
    }
}
