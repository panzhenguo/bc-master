package com.bjttsf.project.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bjttsf.mybatis.BcMapper;
import com.bjttsf.project.model.domain.Project;


@Mapper
public interface ProjectMapper extends BcMapper<Project> {
}