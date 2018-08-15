package com.hnq.study.controller;

import com.hnq.study.dao.domain.master.User;
import com.hnq.study.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author henengqiang
 * @date 2018/8/15
 */
@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/query")
    public User findUserByName(@RequestParam("userName") String userName) {
        return userService.findUserByName(userName);
    }

}
