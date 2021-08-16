package com.wyl.system.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description 角色
 * @Author wy
 * @Date 2021/8/14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "t_role")
public class Role {
    /**
     * 角色id
     */
    @TableId(value = "role_id", type = IdType.ASSIGN_ID)
    private Long roleId;
    /**
     * 角色名
     */
    private String roleName;
    /**
     * 角色介绍
     */
    private String summary;
    /**
     * 状态
     */
    private Integer status;
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
}
