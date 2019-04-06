package com.shiro.test.controller;

import com.shiro.test.filter.MyShiroFilterFactoryBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wang on 2019/3/16.
 */
@Controller
public class PageController {
    @Autowired
    private MyShiroFilterFactoryBean shiroFilterFactoryBean;
    @RequestMapping("/logout.html")
    public String LogOut(){
        Subject sub = SecurityUtils.getSubject();
        sub.logout();
        return "login";
    }
    @RequestMapping("/update.html")
    public String LogOuts(){
        shiroFilterFactoryBean.update();
        return "index";
    }
    @RequestMapping("index.html")
    public String getIndex(){
        return "index";
    }

    @RequestMapping("/error.html")
    public String getError(){
        return "error";
    }

    @RequestMapping("do{path}.html")
    public String page(@PathVariable(name="path")String path, Model model){
        model.addAttribute("path",path);
        return "test";
    }
}
