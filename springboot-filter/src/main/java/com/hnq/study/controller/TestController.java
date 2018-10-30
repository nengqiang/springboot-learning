package com.hnq.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author henengqiang
 * @date 2018/10/30
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private FilterRegistrationBean registrationBean;

    @RequestMapping(value = "hello")
    public String sayHello() {
        return "Hello Boy!";
    }

    @RequestMapping(value = "/get-name")
    public Map<String, String> getName() {
        return registrationBean.getInitParameters();
    }

}
