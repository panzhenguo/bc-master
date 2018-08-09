package com.bjttsf.ur.model.domain;

import java.util.Date;
import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Table(name = "aw_user_role")
public class UserRole {
    @Id
    @ApiModelProperty(value="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 角色名称
     */
    @ApiModelProperty(value="角色名称")
    @Column(name = "role_name")
    private String roleName;

    /**
     * 角色描述
     */
    @ApiModelProperty(value="角色描述")
    @Column(name = "role_description")
    private String roleDescription;

    /**
     * 状态 0 禁用 1 正常
     */
    @ApiModelProperty(value="状态")
    private Integer status;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 创建用户ID （0数据库添加 ）
     */
    @ApiModelProperty(value="创建用户ID")
    @Column(name = "create_user_id")
    private Integer createUserId;

    /**
     * 资源ID 集合
     */
    @ApiModelProperty(value="资源ID集合")
    @Column(name = "resources_ids")
    private String resourcesIds;

}