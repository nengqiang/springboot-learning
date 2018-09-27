package com.hnq.study.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * admin 路由要求只有具有 admin 角色的用户才能访问，edit 路由需要有 delete 权限的用户才能访问，guest 路由要 guest 角色才能访问，login、
 * loginUser 都不做拦截，本文讲解两种拦截方式，对 guest 的拦截是在 controller 对应的方法上加注解，其他是拦截是写在 shiro 的配置类中。
 * 预期分析:
 *  hanif 是有 admin 角色和所有权限，所以用 hanif 登录后，可以访问 edit 和 admin，但是不能访问 guest; 而 alice 是 guest 角色，
 * 只有 create 和 query 权限，所以不能访问 admin 和 edit，但是可以访问 guest。
 *
 * @author henengqiang
 * @date 2018/9/26
 */
@Controller
public class LoginController {

    /**
     * 用户登陆
     */
    @RequestMapping(value = "/loginUser")
    public String loginUser(@RequestParam("userName") String userName,
                            @RequestParam("password") String password,
                            HttpSession session) {
        // 把前端输入的 userName 和 password 封装为 token
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            session.setAttribute("user", subject.getPrincipal());
            return "index";
        } catch (Exception e){
            return "login";
        }
    }

    /**
     * 退出登陆
     */
    @RequestMapping(value = "/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return "login";
    }

    /**
     * 访问 login 时跳转到 login.jsp
     */
    @RequestMapping(value = "/login")
    public String login() {
        // 监控点
        System.out.println("login");
        return "login";
    }

    /**
     * admin 角色才能访问
     */
    @RequestMapping(value = "/admin")
    @ResponseBody
    public String admin() {
       return "admin success";
    }

    /**
     * 有 delete 权限才能访问
     */
    @RequestMapping(value = "/edit")
    @ResponseBody
    public String edit() {
       return "edit success";
    }

    @RequestMapping("/guest")
    @ResponseBody
    @RequiresRoles(value = "guest")
    public String guest() {
        return "This is which guest can see.";
    }

}






















