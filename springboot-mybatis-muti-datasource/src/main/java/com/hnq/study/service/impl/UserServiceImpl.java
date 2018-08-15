package com.hnq.study.service.impl;

import com.hnq.study.dao.domain.cluster.City;
import com.hnq.study.dao.domain.cluster.CityCriteria;
import com.hnq.study.dao.domain.master.User;
import com.hnq.study.dao.domain.master.UserCriteria;
import com.hnq.study.dao.mapper.cluster.CityMapper;
import com.hnq.study.dao.mapper.master.UserMapper;
import com.hnq.study.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author henengqiang
 * @date 2018/8/15
 */
@Service
public class UserServiceImpl implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CityMapper cityMapper;

    @Override
    public User findUserByName(String userName) {
        UserCriteria example = new UserCriteria();
        example.createCriteria().andUserNameEqualTo(userName);
        List<User> users = userMapper.selectByExample(example);
        User user = users.get(0);

        CityCriteria example1 = new CityCriteria();
        example1.createCriteria().andCityNameEqualTo("温岭市");
        List<City> cities = cityMapper.selectByExample(example1);
        City city = cities.get(0);

        user.setCity(city);
        logger.info("查到的数据：{}", user);
        return user;
    }

}
