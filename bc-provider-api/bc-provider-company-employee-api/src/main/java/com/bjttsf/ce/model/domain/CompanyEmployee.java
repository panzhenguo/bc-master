package com.bjttsf.ce.model.domain;

import javax.persistence.*;

import lombok.Data;

@Data
@Table(name = "cw_company_employee")
public class CompanyEmployee {
    /**
     * 员工表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 登录名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 昵称
     */
    @Column(name = "nike_name")
    private String nikeName;

    /**
     * 登录密码
     */
    private String pwd;

    /**
     * 盐值
     */
    @Column(name = "pwd_salt")
    private String pwdSalt;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 身份证
     */
    @Column(name = "id_card")
    private String idCard;

    /**
     * 员工所属公司ID 
     */
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 用户所属部门
     */
    @Column(name = "company_department_id")
    private Integer companyDepartmentId;

    /**
     * 用户角色集合
     */
    @Column(name = "company_role_ids")
    private String companyRoleIds;

    /**
     * 用户状态
     */
    @Column(name = "status")
    private Integer status;

}