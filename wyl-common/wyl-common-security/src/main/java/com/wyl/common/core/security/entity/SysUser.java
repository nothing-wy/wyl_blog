package com.wyl.common.core.security.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

/**
 * @Description
 * @Author wy
 * @Date 2021/8/14
 */
@Data
public class SysUser implements UserDetails, Serializable {
    private static final long serialVersionUID = -2494837359298709959L;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户角色
     */
    private Collection<? extends GrantedAuthority> authorities;
    /**
     * 用户状态 1:正常 0:停用
     */
    private Integer status;
    /**
     * 用户是否过期
     * 默认true 没过期
     */
    private boolean isAccountNonExpired = true;
    /**
     * 用户是否被锁定
     * 默认true 没被锁定
     */
    private boolean isAccountNonLocked = true;
    /**
     * 证书是否过期
     * 默认true 没过期
     */
    private boolean isCredentialsNonExpired = true;

    /**
     * 账户是否有效
     * 默认true 有效
     */
    private boolean isEnabled = true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
