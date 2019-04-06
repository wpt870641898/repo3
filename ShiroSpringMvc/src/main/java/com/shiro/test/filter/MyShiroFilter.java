package com.shiro.test.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by wang on 2019/3/20.
 */
public class MyShiroFilter extends AuthorizationFilter{
    //判断用户是否放行
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest,
                                      ServletResponse servletResponse, Object o) throws Exception {
        Subject sub = getSubject(servletRequest,servletResponse);
        String[] roles = (String[])o;
        if(roles == null || roles.length==0){
            return true;
        }

        for(String role:roles){
            if(sub.hasRole(role)){
                return true;
            }
        }
        return false;
    }
}
