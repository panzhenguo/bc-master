package com.bjttsf.cr.model.domain;

import java.util.Date;
import javax.persistence.*;

import lombok.Data;

@Data
@Table(name = "cw_company_resources")
public class CompanyResources {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 公司id
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 资源名称
     */
    @Column(name = "resources_name")
    private String resourcesName;

    /**
     * 资源描述
     */
    @Column(name = "resources_description")
    private String resourcesDescription;

    /**
     * 资源类型 1菜单 2 按钮
     */
    @Column(name = "resources_type")
    private Integer resourcesType;

    /**
     * 资源地址
     */
    @Column(name = "description_url")
    private String descriptionUrl;

    /**
     * 资源父ID
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 资源父ID 集合
     */
    @Column(name = "parent_ids")
    private Integer parentIds;

    /**
     * 资源状态 0 禁用 1 正常
     */
    private Integer status;

    /**
     * 创建角色的 用户或员工ID 
     */
    @Column(name = "create_ue_id")
    private Integer createUeId;

    /**
     * 创建类型1 管理员用户创建 2 公司员工创建
     */
    @Column(name = "create_ue_type")
    private Integer createUeType;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

   
}