package com.bjttsf.company.model.domain;

import java.util.Date;
import javax.persistence.*;

import lombok.Data;


@Data
@Table(name = "cw_company_department")
public class CompanyDepartemt {
    /**
     * 公司部门表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 所属企业ID 
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 修改时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 创建部门的员工id
     */
    @Column(name = "create_employee_id")
    private Integer createEmployeeId;

    /**
     * 状态
     */
    @Column(name = "status")
    private int status;

}