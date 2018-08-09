package com.bjttsf.ur.model.domain;

import java.util.Date;
import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Table(name = "aw_user_resources")
public class UserResources {
    @Id
    @ApiModelProperty(value="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 资源名称
     */
    @ApiModelProperty(value="资源名称")
    @Column(name = "resources_name")
    private String resourcesName;

    /**
     * 资源描述
     */
    @ApiModelProperty(value="资源描述")
    @Column(name = "resources_description")
    private String resourcesDescription;

    /**
     * 资源类型 1菜单 2 按钮
     */
    @ApiModelProperty(value="资源类型")
    @Column(name = "resources_type")
    private Integer resourcesType;

    /**
     * 资源地址
     */
    @ApiModelProperty(value="资源地址")
    @Column(name = "description_url")
    private String descriptionUrl;

    /**
     * 资源父ID
     */
    @ApiModelProperty(value="资源父ID")
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 资源父ID 集合
     */
    @ApiModelProperty(value="资源父ID集合")
    @Column(name = "parent_ids")
    private Integer parentIds;

    /**
     * 资源状态 0 禁用 1 正常
     */
    @ApiModelProperty(value="资源状态")
    private Integer status;

    /**
     * 创建用户ID （0 数据库手动添加）
     */
    @ApiModelProperty(value="创建用户ID")
    @Column(name = "create_user_id")
    private Integer createUserId;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    @Column(name = "create_date")
    private Date createDate;


}