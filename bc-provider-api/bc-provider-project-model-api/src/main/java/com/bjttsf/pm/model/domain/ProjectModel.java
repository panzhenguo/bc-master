package com.bjttsf.pm.model.domain;

import java.util.Date;
import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Table(name = "pm_project_model")
public class ProjectModel {
    /**
     * 项目模板
     */
    @Id
    @ApiModelProperty(value="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ApiModelProperty(value="模板名称")
    private String name;

    /**
     * 模板详情
     */
    @ApiModelProperty(value="模板详情")
    private String info;
    @ApiModelProperty(value="模板状态")
    private Integer status;

    /**
     * 模板 类型
     */
    @ApiModelProperty(value="模板类型")
    @Column(name = "model_type")
    private Integer modelType;
    @ApiModelProperty(value="创建时间")
    @Column(name = "create_date")
    private Date createDate;
    @ApiModelProperty(value="修改时间")
    @Column(name = "update_date")
    private Date updateDate;
    @ApiModelProperty(value="创建类型 1管理员 2员工")
    @Column(name = "create_ue_type")
    private Integer createUeType;
    @ApiModelProperty(value="创建ID")
    @Column(name = "create_ue_id")
    private Integer createUeId;

}