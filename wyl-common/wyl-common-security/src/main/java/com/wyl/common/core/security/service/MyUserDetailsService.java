package com.wyl.common.core.security.service;

import com.wyl.common.core.security.entity.SysUser;
import com.wyl.system.entity.Role;
import com.wyl.system.entity.User;
import com.wyl.system.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author wy
 * @Date 2021/8/14
 */
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 系统用户
     * @throws UsernameNotFoundException 用户名不存在异常
     */
    @Override
    public SysUser loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.selectUserByUsername(username);
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(user, sysUser);
        List<Role> roles = userService.selectRoleByUserId(user.getUserId());
        // 用户角色集合
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        sysUser.setAuthorities(authorities);
        return sysUser;
    }
}
