package com.bjttsf.cr.model.domain;

import java.util.Date;
import javax.persistence.*;

import lombok.Data;

@Data
@Table(name = "cw_company_role")
public class CompanyRole {
    /**
     * 企业权限表角色
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 公司ID 
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 角色备注
     */
    @Column(name = "role_mark")
    private String roleMark;

    /**
     * 资源集合
     */
    @Column(name = "resources_ids")
    private String resourcesIds;

    /**
     * 状态 0 禁用 1 启用
     */
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 创建角色的 用户 或 员工ID 
     */
    @Column(name = "create_eu_id")
    private Integer createEuId;

    /**
     * 创建类型1管理员用户 创建 2 客户员工创建
     */
    @Column(name = "create_ue_type")
    private Integer createUeType;

   
}