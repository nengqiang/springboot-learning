package com.hnq.study.service.impl;

import com.hnq.study.dao.domain.*;
import com.hnq.study.dao.mapper.PermissionMapper;
import com.hnq.study.dao.mapper.RoleMapper;
import com.hnq.study.dao.mapper.UserMapper;
import com.hnq.study.dao.mapper.ext.UserExtMapper;
import com.hnq.study.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author henengqiang
 * @date 2018/9/26
 */
@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private UserExtMapper userExtMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public User findByUserName(String userName) {
        // 有个 bug，暂停使用
        return userExtMapper.findByUserName(userName);
    }

    @Override
    public User findByUserNameHotfix(String userName) {
        // 多次查询数据库，性能较低
        try {
            UserCriteria userCriteria = new UserCriteria();
            userCriteria.createCriteria().andUserNameEqualTo(userName);
            List<User> userList = userMapper.selectByExample(userCriteria);
            User user = userList.get(0);
            RoleCriteria roleCriteria = new RoleCriteria();
            roleCriteria.createCriteria().andUserIdEqualTo(user.getId());
            List<Role> roleList = roleMapper.selectByExample(roleCriteria);
            PermissionCriteria permissionCriteria = new PermissionCriteria();
            for (Role role : roleList) {
                permissionCriteria.createCriteria().andRoleIdEqualTo(role.getId());
                role.setPermissions(permissionMapper.selectByExample(permissionCriteria));
            }
            user.setRoles(roleList);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
