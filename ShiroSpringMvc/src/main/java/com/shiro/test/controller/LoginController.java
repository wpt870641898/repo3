package com.shiro.test.controller;

import com.shiro.test.pojo.Users;
import com.shiro.test.service.UsersService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wang on 2019/3/16.
 */
@Controller
public class LoginController {

    @Autowired
    private UsersService us;

    @RequestMapping("/gologin")
    public String goLogin(){
        return "login";
    }

    @RequestMapping("login.html")
    public String login(String username, String password, HttpServletRequest req){
            Users user = us.doLogin(username,password);
            if(user == null){
                req.setAttribute("error","用户名或密码错误!");
                return "login";
            }
            return "redirect:index.html";
    }
}
