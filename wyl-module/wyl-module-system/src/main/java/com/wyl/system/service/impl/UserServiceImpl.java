package com.wyl.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wyl.system.entity.Role;
import com.wyl.system.entity.User;
import com.wyl.system.mapper.UserMapper;
import com.wyl.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author wy
 * @Date 2021/8/14
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 用户
     */
    @Override
    public User selectUserByUsername(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        return userMapper.selectOne(wrapper);
    }

    /**
     * 根据用户id查询用户拥有的角色列表
     *
     * @return 用户拥有的角色列表
     */
    @Override
    public List<Role> selectRoleByUserId(Long userId) {
        return userMapper.selectRoleByUserId(userId);
    }

}
