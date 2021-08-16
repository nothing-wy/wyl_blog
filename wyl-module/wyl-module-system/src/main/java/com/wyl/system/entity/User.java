package com.wyl.system.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description 用户
 * @Author wy
 * @Date 2021/8/14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "t_user")
public class User {
    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.ASSIGN_ID)
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
     * 昵称
     */
    private String nickname;
    /**
     * 状态码
     */
    private Integer status;
    /**
     * 性别 1:男 2:女
     */
    private Integer gender;
    /**
     * 个人头像
     */
    private String icon;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 手机
     */
    private String mobile;
    /**
     * 邮箱验证码
     */
    private String validCode;
    /**
     * 自我简介最多150字
     */
    private String summary;
    /**
     * 最后登录时间
     */
    private Date LastLoinTime;
    /**
     * 最后登录ip
     */
    private String lastLoginIp;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    /**
     * 评论状态 1:正常 0:禁言
     */
    private Integer commentStatus;
    /**
     * ip来源
     */
    private String ipSource;
    /**
     * 浏览器
     */
    private String browser;
    /**
     * 操作系统
     */
    private String os;
    /**
     * 角色id
     */
    private Long roleId;
}
