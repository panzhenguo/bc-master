package com.bjttsf.company.model.domain;

import java.util.Date;
import javax.persistence.*;

import lombok.Data;

@Data
@Table(name = "cw_company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 公司名称
     */
    private String name;

    /**
     * 公司简称
     */
    @Column(name = "short_name")
    private String shortName;

    /**
     * 公司名称拼音
     */
    @Column(name = "pinyin_name")
    private String pinyinName;

    /**
     * 简称拼音
     */
    @Column(name = "pinyin_short_name")
    private String pinyinShortName;

    /**
     * 公司地址
     */
    private String address;

    /**
     * 电话
     */
    private String tel;

    /**
     * 备注
     */
    private String remark;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "create_user_id")
    private Integer createUserId;

    /**
     * 状态
     */
    @Column(name = "status")
    private Integer status;

 
}