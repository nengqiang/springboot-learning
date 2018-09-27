package com.hnq.study.dao.mapper.ext;

import com.hnq.study.dao.domain.User;

/**
 * @author henengqiang
 * @date 2018/9/26
 */
public interface UserExtMapper {

    User findByUserName(String userName);

}
