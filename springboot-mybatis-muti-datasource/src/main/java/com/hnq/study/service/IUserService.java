package com.hnq.study.service;

import com.hnq.study.dao.domain.master.User;

/**
 * @author henengqiang
 * @date 2018/8/15
 */
public interface IUserService {

    /**
     * 通过用户名来查找用户
     * @param userName  用户名
     * @return          查到的用户
     */
    User findUserByName(String userName);

}
