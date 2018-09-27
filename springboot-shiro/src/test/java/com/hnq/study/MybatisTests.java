package com.hnq.study;

import com.hnq.study.dao.domain.*;
import com.hnq.study.dao.mapper.PermissionMapper;
import com.hnq.study.dao.mapper.RoleMapper;
import com.hnq.study.dao.mapper.UserMapper;
import com.hnq.study.dao.mapper.ext.UserExtMapper;
import com.hnq.study.service.ILoginService;
import com.hnq.study.utils.CryptUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author henengqiang
 * @date 2018/9/20
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShiroApplication.class)
public class MybatisTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private UserExtMapper userExtMapper;

    @Autowired
    private ILoginService loginService;

    @Test
    public void connectionTest() {
        try {
            UserCriteria example = new UserCriteria();
            example.createCriteria().andIdBetween(1, 100);
            List<User> userList = userMapper.selectByExample(example);
            if (userList != null && userList.size() > 0) {
                System.out.println("查询到数据：");
                for (User user : userList) {
                    System.out.println(user);
                }
            } else {
                System.out.println("未查询到数据");
            }
        } catch (Exception e) {
            System.out.println("查询出错，请稍后再试！");
            e.printStackTrace();
        }
    }

    @Test
    public void insertTest() {
        try {
            User user = new User();
            user.setUserName("alice");
            user.setPassword(CryptUtil.md5Salt("123456", user.getUserName()));
            userMapper.insert(user);
            UserCriteria userCriteria = new UserCriteria();
            userCriteria.createCriteria().andUserNameEqualTo(user.getUserName());
            List<User> users = userMapper.selectByExample(userCriteria);
            Role role = new Role();
            role.setRoleName("user");
            role.setUserId(users.get(0).getId());
            roleMapper.insert(role);
            RoleCriteria roleCriteria = new RoleCriteria();
            roleCriteria.createCriteria().andRoleNameEqualTo(role.getRoleName());
            List<Role> roles = roleMapper.selectByExample(roleCriteria);
            Permission permission = new Permission();
            permission.setPermission("query");
            permission.setRoleId(roles.get(0).getId());
            permissionMapper.insert(permission);
            System.out.println("数据插入成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findTest() {
        User user = userExtMapper.findByUserName("hanif");
        printUserInfo(user);
    }

    @Test
    public void findHotfixTest() {
        User user = loginService.findByUserNameHotfix("hanif");
        printUserInfo(user);
    }

    private void printUserInfo(User user) {
        if (user != null) {
            System.out.println("查询到数据：");
            System.out.println(user);
            List<Role> roleSet = user.getRoles();
            for (Role role : roleSet) {
                List<Permission> permissionSet = role.getPermissions();
                for (Permission permission : permissionSet) {
                    System.out.println(permission);
                }
                System.out.println(role);
            }
        } else {
            System.out.println("未查询到数据");
        }
    }

}




















