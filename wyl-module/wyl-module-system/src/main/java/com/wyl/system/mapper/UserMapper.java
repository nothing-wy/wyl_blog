package com.wyl.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wyl.system.entity.Role;
import com.wyl.system.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description
 * @Author wy
 * @Date 2021/8/14
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据用户id查询用户拥有角色列表
     *
     * @return 用户拥有的角色列表
     */
    List<Role> selectRoleByUserId(Long userId);
}
