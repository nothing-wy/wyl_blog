package com.wyl.system.service;

import com.wyl.system.entity.Role;
import com.wyl.system.entity.User;

import java.util.List;

/**
 * @Description 用户业务接口
 * @Author wy
 * @Date 2021/8/14
 */
public interface UserService {
    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 用户
     */
    User selectUserByUsername(String username);

    /**
     * 根据用户id查询用户拥有角色列表
     *
     * @return 用户拥有的角色列表
     */
    List<Role> selectRoleByUserId(Long userId);
}
