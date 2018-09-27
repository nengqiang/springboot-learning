package com.hnq.study.service;

import com.hnq.study.dao.domain.User;

/**
 * @author henengqiang
 * @date 2018/9/26
 */
public interface ILoginService {

    User findByUserName(String userName);

    User findByUserNameHotfix(String userName);

}
