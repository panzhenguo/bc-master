package com.bjttsf.project.model.domain;

import java.util.Date;
import javax.persistence.*;

import lombok.Data;

@Data
@Table(name = "pm_project")
public class Project {
    /**
     * 项目表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 所属行业
     */
    private Integer industry;

    /**
     * 该项目管理的员工
     */
    @Column(name = "manage_employee_id")
    private Integer manageEmployeeId;

    /**
     * 联系方式
     */
    private String contact;

    /**
     * 项目地址
     */
    private String address;

    /**
     * 项目坐标
     */
    private String coordinate;

    /**
     * 项目备注
     */
    private String marker;

    /**
     * 项目状态
     */
    private Integer status;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "create_ue_type")
    private Integer createUeType;

    @Column(name = "create_ue_id")
    private Integer createUeId;

}